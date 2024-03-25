package com.example.service;

/**
 * Package: com.example.service
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 13:58
 * @Version 1.0
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
