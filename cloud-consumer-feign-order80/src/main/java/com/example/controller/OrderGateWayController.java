package com.example.controller;

import com.example.apis.PayFeignApi;
import com.example.resp.ResultData;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/21 10:44
 * @Version 1.0
 */
@Tag(name = "Gateway", description = "测试Gateway")
@RestController
@RequestMapping("/feign/pay/gateway")
public class OrderGateWayController {
    @Autowired
    private PayFeignApi payFeignApi;

    @GetMapping(value = "{id}")
    public ResultData getById(@PathVariable("id") Integer id)
    {
        return payFeignApi.getByIdGatway(id);
    }

    @GetMapping(value = "info")
    public ResultData<String> getGatewayInfo()
    {
        return payFeignApi.getGatewayInfo();
    }
}
