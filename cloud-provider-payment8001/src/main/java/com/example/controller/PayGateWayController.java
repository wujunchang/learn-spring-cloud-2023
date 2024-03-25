package com.example.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.entities.Pay;
import com.example.resp.ResultData;
import com.example.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/21 10:13
 * @Version 1.0
 */
@Tag(name = "Gateway",description = "测试网光Gateway")
@RestController
@RequestMapping("/pay/gateway")
public class PayGateWayController {
    @Autowired
    PayService payService;

    @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
    @GetMapping(value = "{id}")
    public ResultData<Pay> getByIdGatway(@PathVariable("id") Integer id) {
        if (id == -4) throw new RuntimeException("id不能为负数");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping(value = "info")
    public ResultData<String> getGatewayInfo()
    {
        return ResultData.success("gateway info test："+ IdUtil.simpleUUID());
    }

    @GetMapping(value = "filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        Enumeration<String> headers = request.getHeaderNames();
        System.out.println("============================================BEGIN");
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);
            System.out.println("请求头名: " + headName +"\t\t\t"+"请求头值: " + headValue);
            if(headName.equalsIgnoreCase("X-Request-atguigu1")
                    || headName.equalsIgnoreCase("X-Request-atguigu2")) {
                result = result+headName + "\t " + headValue +" ";
            }
        }

        System.out.println("=============");
        String customerId = request.getParameter("customerId");
        System.out.println("request Parameter customerId: "+customerId);

        String customerName = request.getParameter("customerName");
        System.out.println("request Parameter customerName: "+customerName);
        System.out.println("============================================END\n");
        return ResultData.success("getGatewayFilter 过滤器 test： "+result+" \t "+ DateUtil.now());
    }
}
