package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Package: com.example
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 11:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient3377.class, args);
    }
}
