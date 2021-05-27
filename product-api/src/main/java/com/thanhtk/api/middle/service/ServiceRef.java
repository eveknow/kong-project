package com.thanhtk.api.middle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRef {

    public static ServiceRef serviceRef;

    public ServiceRef() {
        this.serviceRef = this;
    }

}
