package org.lakers.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lakers.domain.LoginUser;
import org.lakers.domain.User;
import org.lakers.mapper.MenuMapper;
import org.lakers.mapper.UserMapper;
import org.lakers.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * Created on 2022/11/3 14:17
 *
 * @author lakers
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserDetailsService, UserService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        Optional<User> userOptional = lambdaQuery().eq(User::getUserName, username).oneOpt();
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("用户名或密码错误！");
        }

        // TODO:查询对应的权限信息
        User user = userOptional.get();
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        return new LoginUser(user, list);

    }
}
