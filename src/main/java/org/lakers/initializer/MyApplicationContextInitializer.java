package org.lakers.initializer;

import org.lakers.processor.MyBeanFactoryPostProcessor;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created on 2023/5/23 19:17
 *
 * @author lakers
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("MyApplicationContextInitializer加载...");
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
    }
}
