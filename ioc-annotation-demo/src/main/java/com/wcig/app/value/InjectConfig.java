package com.wcig.app.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 从其他配置类引入值
 */
@Configuration
public class InjectConfig {

    @Resource
    private DefaultConfig defaultConfig;

    @Value("#{defaultConfig.name}")
    private String name;

    @Value("#{defaultConfig.version}")
    private String version;

    @Override
    public String toString() {
        return "InjectConfig{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                '}';
    }

    public void test() {
        System.out.println(defaultConfig);
    }
}
