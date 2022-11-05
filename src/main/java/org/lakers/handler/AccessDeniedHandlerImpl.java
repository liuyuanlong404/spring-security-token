package org.lakers.handler;

import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import org.lakers.domain.ResponseResult;
import org.lakers.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2022/11/4 14:04
 *
 * @author lakers
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult<String> responseResult = new ResponseResult<>(HttpStatus.HTTP_FORBIDDEN, "你的权限不足！");
        String jsonString = JSON.toJSONString(responseResult);
        // 处理异常
        WebUtils.renderString(response, jsonString);
    }
}
