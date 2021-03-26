package com.wcig.app.service;

import org.springframework.stereotype.Component;

@Component
public class AService {
    public void test() {
        System.out.println("AService test..");
    }

    public void testBefore() {
        System.out.println("AService testBefore..");
    }

    public void testAfter() {
        System.out.println("AService testAfter..");
    }

    public void testAround() {
        System.out.println("AService testAround..");
    }

    public void testAfterReturning1() throws Exception {
        System.out.println("AService testAfterReturning1..");
    }

    public void testAfterReturning2() throws Exception {
        System.out.println("AService testAfterReturning2..");
        throw new Exception("testAfterReturning2");
    }

    public void testAfterThrowing1() throws Exception {
        System.out.println("AService testAfterThrowing1..");
    }

    public void testAfterThrowing2() throws Exception {
        System.out.println("AService testAfterThrowing2..");
        throw new Exception("testAfterThrowing2");
    }
}
