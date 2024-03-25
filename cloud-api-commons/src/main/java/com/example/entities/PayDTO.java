package com.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Package: com.example.entities
 * Description:
 * 一般而言，调用者不应该获悉服务提供者的entity资源并知道表结构关系，所以服务提供方给出的
 * 接口文档都都应成为DTO
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/19 9:59
 * @Version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayDTO {
    private Integer id;
    // 支付流水号
    private String payNo;
    // 订单流水号
    private String orderNo;
    // 用户账号ID
    private Integer userId;
    // 交易金额
    private BigDecimal amount;
}
