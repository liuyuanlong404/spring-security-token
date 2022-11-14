package org.lakers.util.convert;

/**
 * Created on 2022/11/14 13:33
 *
 * @author lakers
 */
public interface Converter {

    boolean support(Class type);
    Object convert(String str, Class type);
}
