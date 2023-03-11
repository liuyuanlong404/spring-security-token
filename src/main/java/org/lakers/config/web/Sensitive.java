package org.lakers.config.web;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2023/3/7 13:38
 *
 * @author lakers
 */
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = ObjectMapperBuilder.SensitiveSerializer.class)
public @interface Sensitive {
    /**
     * 脱敏策略
     */
    SensitiveStrategy value();
}
