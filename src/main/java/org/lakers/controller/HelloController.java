package org.lakers.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2022/11/3 11:23
 *
 * @author lakers
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    @PreAuthorize("hasAuthority('system:dept:test')")
//    @PreAuthorize("hasAnyAuthority('','')")
//    @PreAuthorize("hasRole('')")
//    @PreAuthorize("hasAnyRole('','')")
    // 调用自己的鉴权方法
//    @PreAuthorize("@LakersExpression.authentication('system:dept:test11')")
    public String hello(){
        return "Hello, World!";
    }
}
