package com.example.apis;

import com.example.entities.PayDTO;
import com.example.resp.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {
    /**
     * 新增一条支付相关流水记录
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/pay")
    public ResultData<String> addPay(@RequestBody PayDTO payDTO);


    /**
     * 删除支付流水方法
     *
     * @param id
     * @return
     */
    @DeleteMapping("/pay/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id);

    /**
     * 修改支付流水方法
     *
     * @param id
     * @param payDTO
     * @return
     */

    @PutMapping("/pay/{id}")
    public ResultData<String> updatePay(@PathVariable("id") Integer id, @RequestBody PayDTO payDTO);

    /**
     * 按照主键记录查询支付流水信息
     *
     * @param payDTO
     * @return
     */
    @GetMapping("/pay/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * penfeign天然支持负载均衡演示
     *
     * @return
     */
    @GetMapping("/pay/get/info")
    public String mylb();


    /**
     * 测试CircuitBreaker （Resilience4j）断路器
     *
     * @param id
     * @return
     */
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);


    /**
     * Resilience4j bulkhead 的例子
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    /**
     * Resilience4j ratelimit 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);


    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);


    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/{id}")
    public ResultData getByIdGatway(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();

    @GetMapping(value = "filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request);
}
