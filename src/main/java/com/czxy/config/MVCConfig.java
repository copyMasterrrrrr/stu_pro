package com.czxy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @Author fan
 * @Date 2020/7/9 10:34:35
 * @Version 1.0
 */
//相当于 springmvc.xml
@Configuration
@ComponentScan("com.czxy")
public class MVCConfig {

    //试图解析器
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        //viewResolver.setPrefix("/WEB-INF/jsp/");
//        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}