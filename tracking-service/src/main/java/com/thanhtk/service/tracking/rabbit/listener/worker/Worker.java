package com.thanhtk.service.tracking.rabbit.listener.worker;


import com.thanhtk.service.tracking.exception.InternalException;

public interface Worker {

    void run(String message) throws InternalException;
}
