package org.lakers.filter;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.jetbrains.annotations.NotNull;
import org.lakers.domain.LoginUser;
import org.lakers.util.JWTUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2022/11/3 16:50
 *
 * @author lakers
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)){
            // 放行
            filterChain.doFilter(request, response);
            return;
        }

        // 解析token
        DecodedJWT jwt = JWTUtils.verifyJWT(token);
        Integer userId = jwt.getClaim("userId").asInt();
        String redisKey = "Token:" + userId;
        String object = redisTemplate.opsForValue().get(redisKey);
        if (!StringUtils.hasText(object)){
            throw new RuntimeException("用户未登录");
        }
        LoginUser user = JSON.parseObject(object, LoginUser.class);

        // 存入SecurityContextHolder
        // TODO：获取权限信息封装到Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user,
                null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        filterChain.doFilter(request, response);
    }
}
