package org.lakers;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author lakers
 */
@MapperScan(value = "org.lakers.mapper*")
@SpringBootApplication
@EnableWebMvc
@Slf4j
public class SpringSecurityToken {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityToken.class, args);
        log.info("------------------------SpringSecurityToken Starting Success------------------------------");
    }
}