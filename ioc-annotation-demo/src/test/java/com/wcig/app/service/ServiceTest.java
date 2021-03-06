package com.wcig.app.service;

import com.wcig.app.App;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=App.class)
public class ServiceTest {

    @Autowired
    private AService aService;

    @Test
    public void testInject() {
        Assert.assertNotNull(aService);
        aService.test();
    }
}
