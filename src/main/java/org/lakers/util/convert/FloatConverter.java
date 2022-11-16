package org.lakers.util.convert;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created on 2022/11/14 13:37
 *
 * @author lakers
 */
@Component
@Order(2)
public class FloatConverter implements Converter {

    @Override
    public boolean support(Class type) {
        return type == float.class || type == Float.class;
    }

    @Override
    public Float convert(String str, Class type) {
        return Float.parseFloat(str);
    }
}
