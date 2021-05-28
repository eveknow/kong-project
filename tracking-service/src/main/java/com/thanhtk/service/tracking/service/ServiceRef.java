package com.thanhtk.service.tracking.service;

import com.thanhtk.service.tracking.rabbit.listener.worker.ProductEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRef {

    public static ServiceRef serviceRef;

    public ServiceRef() {
        this.serviceRef = this;
    }

    @Autowired
    public ProductEventHandler productEventHandler;

}
