package com.czxy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Author fan
 * @Date 2020/7/9 10:33:42
 * @Version 1.0
 */

/**
 * 相当于 web.xml
 */
public class WebInitializer implements WebApplicationInitializer {
    //项目启动tomcat后 直接运行配置方法
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //1.初始化spring容器
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        //相当于web.xml 找到 springmvc.xml
        //这里找到MVCConfig 从而知晓mvc要管理那些包
        applicationContext.register(MVCConfig.class);
        applicationContext.setServletContext(servletContext);
        //2.设置核心控制器
        ServletRegistration.Dynamic springMVCServlet = servletContext.addServlet("springmvc", new DispatcherServlet(applicationContext));
        //指定mvc要管理的路径
        springMVCServlet.addMapping("*.action");
        springMVCServlet.setLoadOnStartup(2);

        // post乱码配置
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("CharacterEncodingFilter", new CharacterEncodingFilter("UTF-8"));
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

    }
}
