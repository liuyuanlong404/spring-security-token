//package org.lakers.config;
//
//import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.List;
//
//import static java.util.Collections.singletonList;
//
///**
// * Created on 2022/11/7 19:20
// *
// * @author lakers
// */
//@Configuration
//@EnableSwagger2
//@EnableKnife4j
//public class Swagger2Config {
//
//    @Bean
//    public Docket getUserDocket(){
//        ApiInfo apiInfo=new ApiInfoBuilder()
//                // api标题
//                .title("用户管理")
//                // api描述
//                .description("用户管理相关接口描述")
//                // 版本号
//                .version("1.0.0")
//                // 本API负责人的联系信息
//                .contact(new Contact("Lakers", "https://github.com/liuyuanlong404", "17691354437@qq.com"))
//                .build();
//
//                // 文档类型（swagger2）
//        return new Docket(DocumentationType.SWAGGER_2)
//                // 设置包含在json ResourceListing响应中的api元信息
//                .apiInfo(apiInfo)
//                // 启动用于api选择的构建器
//                .select()
//                // 扫描接口的包
//                .apis(RequestHandlerSelectors.basePackage("org.lakers.controller"))
//                // 路径过滤器（扫描所有路径）
//                .paths(PathSelectors.any())
//                .build()
//                .securityContexts(singletonList(securityContext()))
//                // ApiKey的name需与SecurityReference的reference保持一致
//                .securitySchemes(singletonList(new ApiKey("token", "token", "header")));
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(defaultAuth())
//                //.forPaths(PathSelectors.regex("/*.*"))
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return singletonList(new SecurityReference("token", authorizationScopes));
//    }
//
//}
