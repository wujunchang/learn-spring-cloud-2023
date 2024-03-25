package com.example.controller;

import com.example.apis.PayFeignSentinelApi;
import com.example.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 10:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer/pay/nacos")
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private PayFeignSentinelApi payFeignSentinelApi;


    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        String result = restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
        return result + "\t" + "    我是OrderNacosController83调用者。。。。。。";
    }

    @GetMapping(value = "/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }
}
