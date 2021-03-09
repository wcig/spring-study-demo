package com.wcig.app.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 从配置文件引入值
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DefaultConfig {
    @Value("${app.name}")
    private String name;

    @Value("${app.version}")
    private String version;

    // 设置文件没有定义时的默认值
    @Value("${app.author:Spring}")
    private String author;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "DefaultConfig{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
