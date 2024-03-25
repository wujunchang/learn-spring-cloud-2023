package com.example.service.impl;

import com.example.mapper.AccountMapper;
import com.example.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Package: com.example.service.impl
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 14:10
 * @Version 1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService
{
    @Resource
    AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, Long money) {
        log.info("------->account-service中扣减账户余额开始");

        accountMapper.decrease(userId,money);

        myTimeOut();
        // int age = 10/0;
        log.info("------->account-service中扣减账户余额结束");
    }

    /**
     * 模拟超时异常，全局事务回滚
     */
    private static void myTimeOut()
    {
        try { TimeUnit.SECONDS.sleep(65); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
