package com.czxy.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;


/**
 * @Author fan
 * @Date 2020/7/7 17:06:30
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.czxy"}) //扫描的包
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
@EnableAspectJAutoProxy
public class SpringConfig {
    // 4.2.4版本 固定配置
    @Bean
    public static PropertySourcesPlaceholderConfigurer create(){
        return  new PropertySourcesPlaceholderConfigurer();
    }

    //读取数据库相关配置
    @Value("${jdbc.diverName}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    //数据源使用德鲁伊连接池
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClass);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    @Resource
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    // 开启事务管理器
    @Bean
    @Resource
    public DataSourceTransactionManager txManager(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }

}
