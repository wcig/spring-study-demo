package com.wcig.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class EmailService {

    @Autowired
    UserService userService;

    public String sendMail() {
        ZoneId zoneId = userService.getZoneId(); // ok
        // ZoneId zoneId = userService.zoneId; // null
        // ZoneId zoneId = userService.getFinalZoneId(); // null
        String dt = ZonedDateTime.now(zoneId).toString();
        return "Hello, it is " + dt;
    }

}
