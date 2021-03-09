package com.wcig.app.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BlockedListNotifier {

    private static final String notificationAddress = "b@example.org";

    @EventListener
    // @Async
    // 加此配置可异步执行监听的事件处理: 1)listener抛异常不会传播到调用方; 2)不能应用于连续的事件监听; 3)需在项目配置注解@EnableAsync生效.
    public void processBlockedListEvent(BlockedListEvent event) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("BlockedListNotifier receive event: %s, start notify address: %s\n",
                event, notificationAddress);
    }
}
