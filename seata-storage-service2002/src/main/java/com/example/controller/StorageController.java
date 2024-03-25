package com.example.controller;

import com.example.resp.ResultData;
import com.example.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package: com.example.controller
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/25 14:03
 * @Version 1.0
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */

    @RequestMapping("/storage/decrease")
    public ResultData decrease(Long productId, Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功!");
    }
}
