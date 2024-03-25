package com.example.controller;

import com.example.apis.PayFeignApi;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/20 17:03
 * @Version 1.0
 */
@RestController
public class OrderMicrometerController {
    @Resource
    private PayFeignApi payFeignApi;

    @Operation(summary = "Micrometer(Sleuth)进行链路监控的例子")
    @GetMapping(value = "/feign/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id)
    {
        return payFeignApi.myMicrometer(id);
    }
}
