package org.lakers.aop;

/**
 * Created on 2022/11/17 11:34
 *
 * @author lakers
 */
@FunctionalInterface
public interface LogConvert<T> {

    OperateLog convert(T t);
}
