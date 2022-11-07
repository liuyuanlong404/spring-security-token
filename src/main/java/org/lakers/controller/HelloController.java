package org.lakers.controller;

import org.lakers.common.UserVo;
import org.lakers.domain.ResponseResult;
import org.lakers.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created on 2022/11/3 11:23
 *
 * @author lakers
 */
@RestController
public class HelloController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/helloLoginUser")
    @PreAuthorize("hasAuthority('system:dept:test')")
//    @PreAuthorize("hasAnyAuthority('','')")
//    @PreAuthorize("hasRole('')")
//    @PreAuthorize("hasAnyRole('','')")
    // 调用自己的鉴权方法
//    @PreAuthorize("@LakersExpression.authentication('system:dept:test11')")
    public ResponseResult<UserVo> hello(){
        UserVo vo = userService.getUserVo();
        return ResponseResult.success(vo);
    }
}
