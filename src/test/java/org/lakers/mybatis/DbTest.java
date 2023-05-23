package org.lakers.mybatis;

import com.baomidou.mybatisplus.extension.toolkit.Db;
import org.junit.jupiter.api.Test;
import org.lakers.BaseTest;
import org.lakers.domain.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2023/4/26 11:20
 *
 * @author lakers
 */
public class DbTest extends BaseTest {

    @Test
    void listTest() {
        List<User> users = Db.listByIds(Arrays.asList(1L, 2L), User.class);
        System.out.println(users);
    }

    @Test
    void mapTest() {

    }
}
