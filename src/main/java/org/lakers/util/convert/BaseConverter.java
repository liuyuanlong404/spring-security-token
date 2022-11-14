package org.lakers.util.convert;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2022/11/14 13:52
 *
 * @author lakers
 */
@Component
public class BaseConverter implements Converter {

    public List<Converter> converterList = new ArrayList<>();

//    public BaseConverter() {
//        converterList.add(new IntegerConverter());
//        converterList.add(new FloatConverter());
//    }

    @Override
    public boolean support(Class type) {
        return converterList.stream().anyMatch(t -> t.support(type));
    }

    @Override
    public Object convert(String str, Class type) {
        for (Converter converter : converterList) {
            if (converter.support(type)) {
                return converter.convert(str, type);
            }
        }
        throw new IllegalArgumentException();
    }
}
