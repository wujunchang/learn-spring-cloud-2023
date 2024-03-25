package com.example.controller;

import com.example.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/20 14:59
 * @Version 1.0
 */
@RestController
public class OrderCircuitController {
    @Autowired
    private PayFeignApi payFeignApi;

    @Operation(summary = "测试 Resilience4j 熔断(CircuitBreaker)")
    @GetMapping(value = "/feign/pay/circuit/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "myCircuitFallback")
    public String myCircuitBreaker(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    // myCircuitFallback就是服务降级后的兜底处理方法
    public String myCircuitFallback(Integer id, Throwable t) {
        // 这里是容错处理逻辑，返回备用结果
        return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }


    /**
     * (船的)舱壁,隔离
     * @param id
     * @return
     */
    @Operation(summary = "测试 Resilience4j 隔离(Bulkhead) SEMAPHORE")
    @GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignApi.myBulkhead(id);
    }
    public String myBulkheadFallback(Throwable t)
    {
        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }

    @Operation(summary = "测试 Resilience4j 隔离(Bulkhead)  THREADPOOL")
    @GetMapping(value = "/feign/pay/bulkhead/{id}/threadpool")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> myBulkheadTHREADPOOL(@PathVariable("id") Integer id)
    {
        System.out.println(Thread.currentThread().getName()+"\t"+"enter the method!!!");
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName()+"\t"+"exist the method!!!");

        return CompletableFuture.supplyAsync(() -> payFeignApi.myBulkhead(id) + "\t" + " Bulkhead.Type.THREADPOOL");
    }
    public CompletableFuture<String> myBulkheadPoolFallback(Integer id,Throwable t)
    {
        return CompletableFuture.supplyAsync(() -> "Bulkhead.Type.THREADPOOL，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
    }


    @Operation(summary = "测试 Resilience4j Ratelimiter（限流）")
    @GetMapping(value = "/feign/pay/ratelimit/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRatelimitFallback")
    public String myRatelimit(@PathVariable("id") Integer id)
    {
        return payFeignApi.myRatelimit(id);
    }
    public String myRatelimitFallback(Integer id,Throwable t)
    {
        return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
    }
}
