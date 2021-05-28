package com.thanhtk.service.tracking.rabbit.listener.worker;

import com.google.gson.Gson;
import com.thanhtk.service.tracking.db.entity.ProductEventEntity;
import com.thanhtk.service.tracking.db.repo.ProductEventRepository;
import com.thanhtk.service.tracking.exception.InternalException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductEventHandler implements Worker {

    private static final Logger logger = Logger.getLogger(ProductEventHandler.class);
    public  static final String name = "product_event";

    @Autowired
    ProductEventRepository productEventRepository;

    @Override
    public void run(String message) throws InternalException {
        logger.info("Trigger reload config from database.");
        ProductEventEntity productEventEntity = new Gson().fromJson(message, ProductEventEntity.class);
        productEventRepository.save(productEventEntity);
    }
}
