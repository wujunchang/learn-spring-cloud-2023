package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Package: example
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/18 14:20
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.example.mapper")
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
@RefreshScope // 动态刷新
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}
