package org.lakers.controller;

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
@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping(value = "/user/login")
    public ResponseResult<Map<String, String>> login(@RequestBody User user){
        return loginService.login(user);
    }

    @GetMapping(value = "/user/logout")
    public ResponseResult<Void> logout(){
        return loginService.logout();
    }
}
