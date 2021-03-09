package com.wcig.app.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 从其他配置类引入值
 */
@Configuration
public class InjectConfig {
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
}
