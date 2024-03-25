package com.example.controller;

import com.example.resp.ResultData;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 14:09
 * @Version 1.0
 */
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public ResultData<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money){
        accountService.decrease(userId,money);
        return ResultData.success("扣减账户余额成功！");
    }
}
