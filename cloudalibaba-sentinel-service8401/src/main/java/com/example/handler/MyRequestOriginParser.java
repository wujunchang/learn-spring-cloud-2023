package com.example.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * Package: com.example.handler
 * Description:
 *
 * @Author jim@rtshield.com
 * @Create 2024/3/22 16:41
 * @Version 1.0
 */
@Component
public class MyRequestOriginParser implements RequestOriginParser
{
    @Override
    public String parseOrigin(HttpServletRequest request)
    {
        return request.getParameter("serverName");
    }
}
