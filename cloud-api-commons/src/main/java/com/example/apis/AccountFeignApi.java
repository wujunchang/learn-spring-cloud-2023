package com.example.apis;

import com.example.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Package: com.example.apis
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 11:34
 * @Version 1.0
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
    // 扣减账户余额
    @PostMapping("/account/decrease")
    ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
