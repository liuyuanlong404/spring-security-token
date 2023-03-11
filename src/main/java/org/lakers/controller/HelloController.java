package org.lakers.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.lakers.common.UserVo;
import org.lakers.domain.ResponseResult;
import org.lakers.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/11/3 11:23
 *
 * @author lakers
 */
@Api(tags = "测试管理")
@RestController
public class HelloController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "获取登录人信息")
    @GetMapping(value = "/helloLoginUser")
    @PreAuthorize("hasAuthority('system:dept:test')")
//    @PreAuthorize("hasAnyAuthority('','')")
//    @PreAuthorize("hasRole('')")
//    @PreAuthorize("hasAnyRole('','')")
    // 调用自己的鉴权方法
//    @PreAuthorize("@LakersExpression.authentication('system:dept:test11')")
    public ResponseResult<UserVo> hello() {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(1));


        UserVo vo = userService.getUserVo();
        return ResponseResult.success(vo);
    }
    
}
