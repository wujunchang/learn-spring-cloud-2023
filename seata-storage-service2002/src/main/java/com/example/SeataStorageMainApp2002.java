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
 * @Create 2024/3/25 13:53
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.example.mapper") // import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient // 服务注册和发现
@EnableFeignClients
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }
}
