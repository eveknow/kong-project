package com.thanhtk.api.product.client.rabbit;

import com.google.gson.Gson;
import com.thanhtk.api.product.config.ProductApiRabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitServiceImpl {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendEvent(ProductEvent productEvent){
        rabbitTemplate.convertAndSend(ProductApiRabbitMQConfig.getInstanceRef().getExchange(),
                ProductApiRabbitMQConfig.getInstanceRef().getProductEvent(), productEvent);

    }

}
