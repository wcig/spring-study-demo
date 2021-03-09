package com.wcig.app.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class EmailService implements ApplicationEventPublisherAware {

    private static final List<String> blockedList = Arrays.asList("a1@example.org", "a2@example.org", "a3@example.org");
    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendEmail(String address, String content) {
        if (blockedList.contains(address)) {
            publisher.publishEvent(new BlockedListEvent(this, address, content));
            System.out.println("blocked email..");
            return;
        }
        System.out.println("send email..");
    }
}
