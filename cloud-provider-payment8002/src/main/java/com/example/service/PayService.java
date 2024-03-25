package com.example.service;

import com.example.entities.Pay;

import java.util.List;

/**
 * Package: com.example.service
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/18 14:25
 * @Version 1.0
 */

public interface PayService {
    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
