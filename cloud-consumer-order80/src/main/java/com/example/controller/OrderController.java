package com.example.controller;


import com.example.entities.PayDTO;
import com.example.resp.ResultData;
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
@RequestMapping("/consumer/pay")
@RestController
public class OrderController {
    // 先写死，硬编码
    // public static final String PAYMENT_SRV_URL = "http://localhost:8001";
    // 服务注册中心上的微服务名称
    public static final String PAYMENT_SRV_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

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
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay", payDTO, ResultData.class);
    }

    @Operation(summary = "获取支付记录详情")
    @GetMapping("/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/" + id, ResultData.class, id);
    }

    @Operation(summary = "删除支付记录")
    @DeleteMapping("/{id}")
    public void delPay(@PathVariable("id") Integer id) {
        restTemplate.delete(PAYMENT_SRV_URL + "/pay/" + id, id);
    }

    @Operation(summary = "修改支付记录")
    @PutMapping("/{id}")
    public void updatePay(@PathVariable("id") Integer id, @RequestBody PayDTO payDTO) {
        restTemplate.put(PAYMENT_SRV_URL + "/pay/" + id, payDTO);
    }

    @GetMapping("/get/info")
    private String getInfoByConsul() {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/info", String.class);
    }
}
