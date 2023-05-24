package org.lakers.initializer;

import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created on 2023/5/24 10:36
 *
 * @author lakers
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(org.springframework.boot.ApplicationArguments args) throws Exception {
        System.out.println("MyApplicationRunner执行...");
    }
}

