package com.example.apis;

import com.example.resp.ResultData;
import com.example.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * Package: com.example.apis
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 17:09
 * @Version 1.0
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi{
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
