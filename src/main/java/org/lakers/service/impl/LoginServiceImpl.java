package org.lakers.service.impl;

import com.alibaba.fastjson.JSON;
import org.lakers.domain.LoginUser;
import org.lakers.domain.ResponseResult;
import org.lakers.domain.User;
import org.lakers.service.LoginService;
import org.lakers.util.JWTUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created on 2022/11/3 15:48
 *
 * @author lakers
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ResponseResult<Map<String, String>> login(User user) {
        // AuthenticationManager.authenticate()进行验证
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登录失败！");
        }

        // 登录成功生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String token = JWTUtils.createToken(loginUser.getUser().getId().intValue());
        HashMap<String, String> resultMap = new HashMap<>(1);
        resultMap.put("token", token);

        redisTemplate.opsForValue().set("Token:" + loginUser.getUser().getId(), JSON.toJSONString(loginUser));
        return new ResponseResult<>(200, "登录成功", resultMap);
    }

    @Override
    public ResponseResult<Void> logout() {
        // 获取SecurityContextHolder获取登录用户的id
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = (LoginUser) authentication.getPrincipal();

        // 删除redis
        redisTemplate.delete("Token:" + user.getUser().getId());
        return new ResponseResult<>(200, "注销成功！");
    }
}
