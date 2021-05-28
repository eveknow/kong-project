package com.thanhtk.service.tracking.rabbit.listener.worker;


import com.thanhtk.service.tracking.exception.InternalException;
import com.thanhtk.service.tracking.service.ServiceRef;

public class WorkerManager {

    private WorkerManager() {
    }

    public static Worker getWorker(String name) throws InternalException {
        switch (name){
            case ProductEventHandler.name:
                return ServiceRef.serviceRef.productEventHandler;
        }

        throw new InternalException(String.format("No supported worker %s.", name));
    }
}
