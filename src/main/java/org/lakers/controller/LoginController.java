package org.lakers.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lakers.domain.ResponseResult;
import org.lakers.domain.User;
import org.lakers.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created on 2022/11/3 15:47
 *
 * @author lakers
 */
@Api(tags = "登录注销管理")
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user){
        return loginService.login(user);
    }

    @ApiOperation(value = "注销")
    @GetMapping(value = "/user/logout")
    public ResponseResult<Void> logout(){
        return loginService.logout();
    }
}
