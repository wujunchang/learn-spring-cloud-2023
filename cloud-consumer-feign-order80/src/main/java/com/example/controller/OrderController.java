package com.example.controller;


import cn.hutool.core.date.DateUtil;
import com.example.apis.PayFeignApi;
import com.example.entities.PayDTO;
import com.example.resp.ResultData;
import com.example.resp.ReturnCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/19 10:13
 * @Version 1.0
 */
@RequestMapping("/feign/pay")
@RestController
public class OrderController {
    @Autowired
    private PayFeignApi payFeignApi;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @Operation(summary = "添加支付记录")
    @PostMapping("")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        System.out.println("第一步：模拟本地addOrder新增订单成功(省略sql操作)，第二步：再开启addPay支付微服务远程调用");
        return payFeignApi.addPay(payDTO);
    }

    @Operation(summary = "获取支付记录详情")
    @GetMapping("/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        System.out.println("-------支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try {
            System.out.println("调用开始-----: " + DateUtil.now());
            resultData = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----: "+ DateUtil.now());
            ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return resultData;

    }

    @Operation(summary = "删除支付记录")
    @DeleteMapping("/{id}")
    public void delPay(@PathVariable("id") Integer id) {
        payFeignApi.deletePay(id);
    }

    @Operation(summary = "修改支付记录")
    @PutMapping("/{id}")
    public void updatePay(@PathVariable("id") Integer id, @RequestBody PayDTO payDTO) {
        payFeignApi.updatePay(id, payDTO);
    }

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping("/get/mylb")
    private String getInfoByConsul() {
        return payFeignApi.mylb();
    }
}
