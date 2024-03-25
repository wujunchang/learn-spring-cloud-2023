package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 14:44
 * @Version 1.0
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "----------------------A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------testB";
    }


    /**
     * 流控-链路演示demo
     * C和D两个请求都访问flowLimitService.common()方法，阈值到达后对C限流，对D不管
     */
    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testC")
    public String testC() {
        flowLimitService.common();
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "------testD";
    }


    @GetMapping("/testE")
    public String testE() {
        System.out.println(System.currentTimeMillis() + "      testE,排队等待");
        return "------testE";
    }

    /**
     * 新增熔断规则-慢调用比例
     *
     * @return
     */
    @GetMapping("/testF")
    public String testF() {
        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----测试:新增熔断规则-慢调用比例 ");
        return "------testF 新增熔断规则-慢调用比例";
    }

    /**
     * 新增熔断规则-异常比例
     *
     * @return
     */
    @GetMapping("/testG")
    public String testG() {
        System.out.println("----测试:新增熔断规则-异常比例 ");
        int age = 10 / 0;
        return "------testG,新增熔断规则-异常比例 ";
    }

    /**
     * 新增熔断规则-异常数
     *
     * @return
     */
    @GetMapping("/testH")
    public String testH() {
        System.out.println("----测试:新增熔断规则-异常数 ");
        int age = 10 / 0;
        return "------testH,新增熔断规则-异常数 ";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,

                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey 限流";
    }
}
