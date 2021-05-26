package com.thanhtk.api.user.service;

import com.thanhtk.api.user.client.kong.KongClientHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRef {

    public static ServiceRef serviceRef;

    public ServiceRef() {
        this.serviceRef = this;
    }

    @Autowired
    public KongClientHelper kongClientHelper;
}
