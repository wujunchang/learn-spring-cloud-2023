package com.example.service;

import com.example.entities.Order;

/**
 * Package: com.example.service
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 11:41
 * @Version 1.0
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
