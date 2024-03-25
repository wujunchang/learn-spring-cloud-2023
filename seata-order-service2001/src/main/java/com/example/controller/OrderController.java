package com.example.controller;

import com.example.entities.Order;
import com.example.resp.ResultData;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 11:43
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    // 创建订单
    @GetMapping("/order/create")
    public ResultData<Order> create(Order order){
        orderService.create(order);
        return ResultData.success(order);
    }
}
