package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * Package: com.example
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 14:07
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient // 服务注册和发现
@MapperScan("com.example.mapper")
@EnableFeignClients
public class SeataAccountMainApp2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp2003.class, args);
    }
}
