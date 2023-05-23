package org.lakers;

import org.junit.jupiter.api.Test;
import org.lakers.service.ElapsedTimeService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * Created on 2023/3/22 21:10
 *
 * @author lakers
 */
@SpringBootTest
public class EnableTimeAnnoTest {

    @Resource
    private ElapsedTimeService elapsedTimeService;

    @Test
    public void test() {
        elapsedTimeService.testA();
        elapsedTimeService.testB();
    }
}
