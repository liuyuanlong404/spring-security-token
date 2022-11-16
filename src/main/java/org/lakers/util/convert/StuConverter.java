package org.lakers.util.convert;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created on 2022/11/14 14:21
 *
 * @author lakers
 */
@Component
@Order(3)
public class StuConverter implements Converter {
    @Override
    public boolean support(Class type) {
        return type == Stu.class;
    }

    @Override
    public Object convert(String str, Class type) {
        String[] split = str.split(",");
        Stu stu = new Stu();
        stu.setName(split[0]);
        stu.setAge(Integer.valueOf(split[1]));
        return stu;
    }
}
