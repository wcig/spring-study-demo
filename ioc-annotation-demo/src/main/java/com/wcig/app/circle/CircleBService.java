package com.wcig.app.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring解决循环依赖注入的方式: 先调用构造函数构造对下,然后通过set方法或反射将依赖的对象添加到对象的变量中去.
 * 验证方式: 只添加有参的构造函数,而省略无参构造函数
 */
@Component
public class CircleBService {
    @Autowired
    private CircleAService circleAService;

    public CircleBService() {
    }

    public CircleBService(CircleAService circleAService) {
        this.circleAService = circleAService;
    }
}
