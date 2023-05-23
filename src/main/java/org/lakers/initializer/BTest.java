package org.lakers.initializer;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 2023/5/23 19:32
 *
 * @author lakers
 */
@Component
public class BTest {

    @PostConstruct
    public void showMap() {
        String lakers = C02Test.getMap("Lakers");
        System.out.println("输出-------" + lakers);
    }
}
