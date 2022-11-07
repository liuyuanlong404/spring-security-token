package org.lakers.config;

import org.lakers.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Created on 2022/11/3 14:53
 *
 * @author lakers
 */
@EnableWebSecurity
// 开启注解权限配置
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Resource
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager () throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        return http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 放行swagger
                .antMatchers("/swagger-ui.html","/swagger-resources/**","/webjars/**","/v2/**","/api/**").permitAll()
                // 放行登录接口 anonymous允许匿名用户访问,不允许已登入用户访问
                .antMatchers("/user/login").anonymous()
                .anyRequest().authenticated()
                .and()
                // 将token校验添加到过滤器链中
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 配置异常处理器
                .exceptionHandling()
                // 配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                // 配置授权失败处理器
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                // 允许跨域
                .cors()
                .and()
                .build();
    }

}
