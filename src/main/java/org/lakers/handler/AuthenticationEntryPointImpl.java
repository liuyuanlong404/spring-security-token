package org.lakers.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import org.lakers.domain.ResponseResult;
import org.lakers.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2022/11/4 13:58
 *
 * @author lakers
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult<String> responseResult = new ResponseResult<>(HttpStatus.HTTP_UNAUTHORIZED, "用户认证失败请重新登录！");
        String jsonString = JSON.toJSONString(responseResult);
        // 处理异常
        WebUtils.renderString(response, jsonString);
    }
}
