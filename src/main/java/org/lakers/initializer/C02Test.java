package org.lakers.initializer;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2023/5/23 19:30
 *
 * @author lakers
 */
//@Component
public class C02Test implements InitializingBean {

    public static final Map<String, String> MAP = new HashMap<>();

    @PostConstruct
    public void initMap() {
        MAP.put("Lakers", "Lakers");
        MAP.put("Rose", "Rose");
    }

    public static String getMap(String key){
        return MAP.get(key);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("C02test执行afterPropertiesSet()");
    }
}
