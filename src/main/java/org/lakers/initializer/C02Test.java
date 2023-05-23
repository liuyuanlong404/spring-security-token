package org.lakers.initializer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2023/5/23 19:30
 *
 * @author lakers
 */
public class C02Test {

    public static final Map<String, String> MAP = new HashMap<>();

    @PostConstruct
    public void initMap() {
        MAP.put("Lakers", "Lakers");
        MAP.put("Rose", "Rose");
    }

    public static String getMap(String key){
        return MAP.get(key);
    }
}
