package org.lakers.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;
import org.junit.jupiter.api.Test;
import org.lakers.BaseTest;
import org.lakers.domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created on 2023/4/26 11:20
 *
 * @author lakers
 */
public class SimpleQueryTest extends BaseTest {

    @Test
    void listTest() {
        List<String> list = SimpleQuery.list(new LambdaQueryWrapper<User>().eq(User::getId, 1), user -> user.getUserName() + user.getPassword(), System.out::println);
        list.forEach(System.out::println);
    }

    @Test
    void mapTest() {
        Map<Long, User> idEntityMap = SimpleQuery.keyMap(Wrappers.<User>lambdaQuery().eq(User::getId, 1L), User::getId);
        // 校验结果
        User entity = new User();
        entity.setId(1L);
        entity.setUserName("Lakers");
        Assert.isTrue(idEntityMap.equals(Collections.singletonMap(1L, entity)), "Ops!");
    }
}
