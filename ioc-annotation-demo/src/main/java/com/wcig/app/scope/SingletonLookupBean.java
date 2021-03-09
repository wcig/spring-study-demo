package com.wcig.app.scope;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonLookupBean {
    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null;
    }
}
