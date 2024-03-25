package com.example.service.impl;

import com.example.mapper.StorageMapper;
import com.example.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.example.service.impl
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 13:58
 * @Version 1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId,count);
        log.info("------->storage-service中扣减库存结束");
    }
}
