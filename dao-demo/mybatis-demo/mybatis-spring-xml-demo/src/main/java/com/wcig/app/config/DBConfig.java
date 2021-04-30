package com.wcig.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

// 使用配置类+注解方式集成mybatis,不需要mybatis-config.xml
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan("com.wcig.app.dao")
public class DBConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    // 初始druid数据源
    @Bean
    public DataSource druidDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(10);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(200);
        return dataSource;
    }

    // 初始化mybatis SqlSessionFactory
    @Bean
    public SqlSessionFactory initSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDatasource());
        sqlSessionFactoryBean.setMapperLocations(resolveMapperLocations());
        sqlSessionFactoryBean.setPlugins(initPageHelperInterceptor());
        sqlSessionFactoryBean.setTypeAliasesPackage("com.wcig.app.model");
        return sqlSessionFactoryBean.getObject();
    }

    // 以spring方式配置事务
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(druidDatasource());
    }

    // 配置mybatis xml映射文件扫描路径
    public Resource[] resolveMapperLocations() throws Exception {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        return resourceResolver.getResources("classpath*:sqlmap/**/*.xml");
    }

    // 配置mybatis分页
    public PageInterceptor initPageHelperInterceptor() {
        Properties pageInterceptorProperties = new Properties();
        pageInterceptorProperties.setProperty("helperDialect", "mysql");
        pageInterceptorProperties.setProperty("supportMethodsArguments", "true");

        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(pageInterceptorProperties);
        return pageInterceptor;
    }
}
