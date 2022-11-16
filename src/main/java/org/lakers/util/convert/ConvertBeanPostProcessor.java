package org.lakers.util.convert;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created on 2022/11/14 14:56
 *
 * @author lakers
 */
@Configuration
public class ConvertBeanPostProcessor implements BeanPostProcessor {

    @Resource
    private BaseConverter converter;

    @Override
    public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName) throws BeansException {

//        if (bean instanceof Converter && !(bean instanceof BaseConverter)){
//            System.out.println(bean + "beanName : " + beanName);
//            converter.converterList.add((Converter) bean);
//        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
