package com.wcig.app.pcd;

import com.wcig.app.model.User;
import org.springframework.stereotype.Component;

@Component
public class Args2Service {
    public void test(User user) {
        System.out.println("Args2Service " + user.getName() + " test..");
    }
}
