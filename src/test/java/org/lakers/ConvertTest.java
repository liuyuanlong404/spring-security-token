package org.lakers;

import org.junit.jupiter.api.Test;
import org.lakers.util.convert.BaseConverter;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created on 2022/11/14 15:09
 *
 * @author lakers
 */
@SpringBootTest
public class ConvertTest {

    @Resource
    public BaseConverter baseConverter;

    @Test
    public void test(){
        System.out.println(baseConverter.convert("25", Long.class));
    }
}
