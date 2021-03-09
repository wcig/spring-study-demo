package com.wcig.app.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequiredAService {
    @Autowired(required = false)
    private RequiredBService requiredBService;
}
