package com.example.service;
import org.apache.ibatis.annotations.Param;

/**
 * Package: com.example.service
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 14:09
 * @Version 1.0
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 本次消费金额
     */
    void decrease(@Param("userId") Long userId, @Param("money") Long money);

}
