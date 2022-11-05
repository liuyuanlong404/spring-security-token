package org.lakers.expression;

import org.lakers.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created on 2022/11/4 15:17
 *
 * @author lakers
 */
@Component("LakersExpression")
public class LakersExpressionRoot {

    public boolean authentication(String authority) {
        // 获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();

        // 鉴权
        return permissions.contains(authority);
    }
}
