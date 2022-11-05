package org.lakers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lakers
 */
@MapperScan(value = "org.lakers.mapper*")
@SpringBootApplication
public class SpringSecurityToken {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityToken.class, args);
    }
}