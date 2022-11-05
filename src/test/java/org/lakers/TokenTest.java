package org.lakers;

import org.junit.jupiter.api.Test;
import org.lakers.domain.User;
import org.lakers.mapper.MenuMapper;
import org.lakers.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created on 2022/11/3 14:05
 *
 * @author lakers
 */
@SpringBootTest
public class TokenTest {

    @Resource
    public UserMapper userMapper;

    @Resource
    public MenuMapper menuMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testPasswordEncoder(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);

        boolean matches = passwordEncoder.matches("1234",
                "$2a$10$N2jarMbif8cY6D3/x3zLme4kHB1DG/pLaQYH9aOxHWKmPwbUz7B5W");
        System.out.println(matches);
    }

    @Test
    public void menuTest(){
        List<String> perms = menuMapper.selectPermsByUserId(1L);
        perms.forEach(System.out::println);
    }
}
