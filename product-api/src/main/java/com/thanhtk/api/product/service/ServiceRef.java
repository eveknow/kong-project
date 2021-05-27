package com.thanhtk.api.product.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceRef {

    public static ServiceRef serviceRef;

    public ServiceRef() {
        this.serviceRef = this;
    }

}
