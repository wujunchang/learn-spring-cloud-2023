package com.example.service.impl;

import com.example.entities.Pay;
import com.example.mapper.PayMapper;
import com.example.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Package: com.example.service.impl
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/18 14:28
 * @Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayMapper payMapper;

    @Override
    public int add(Pay pay)
    {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id)
    {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay)
    {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id)
    {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll()
    {
        return payMapper.selectAll();
    }
}
