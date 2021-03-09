package com.wcig.app.event;

import org.springframework.context.ApplicationListener;

public class BlockedListNotifier implements ApplicationListener<BlockedListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @Override
    public void onApplicationEvent(BlockedListEvent event) {
        System.out.printf("BlockedListNotifier receive event: %s, start notify address: %s\n",
                event, this.notificationAddress);
    }
}
