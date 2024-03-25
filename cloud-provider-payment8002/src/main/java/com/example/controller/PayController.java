package com.example.controller;

import com.example.entities.Pay;
import com.example.entities.PayDTO;
import com.example.resp.ResultData;
import com.example.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/18 14:35
 * @Version 1.0
 */
@Tag(name = "支付微服务模块", description = "支付CRUD")
@RestController
@RequestMapping("pay")
public class PayController {
    @Autowired
    PayService payService;

    @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
    @PostMapping()
    public ResultData<String> addPay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @Operation(summary = "删除", description = "删除支付流水方法")
    @DeleteMapping(value = "{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return ResultData.success(i);
    }

    @Operation(summary = "修改", description = "修改支付流水方法")
    @PutMapping(value = "{id}")
    public ResultData<String> updatePay(@PathVariable("id") Integer id, @RequestBody PayDTO payDTO) {
        payDTO.setId(id);
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    @GetMapping(value = "{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        if (id == -4) throw new RuntimeException("id不能为负数");
        return ResultData.success(payService.getById(id));
    }

    @Operation(summary = "查询所有流水")
    public ResultData<List<Pay>> getAll() {
        return ResultData.success(payService.getAll());
    }




    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/get/info")
    public String getInfoByConsul(@Value("${example.info}") String exampleInfo)
    {
        return "exampleInfo: "+exampleInfo+"\t"+"port: "+port;
    }

}
