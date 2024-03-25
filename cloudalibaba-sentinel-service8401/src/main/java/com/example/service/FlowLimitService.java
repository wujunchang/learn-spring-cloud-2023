package com.example.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * Package: com.example.service
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 15:09
 * @Version 1.0
 */
@Service
public class FlowLimitService {
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}
