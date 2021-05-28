package com.thanhtk.api.product.client.redis;

import com.google.gson.Gson;
import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.client.rabbit.ProductEvent;
import com.thanhtk.api.product.config.ProductApiRabbitMQConfig;
import com.thanhtk.api.product.endpoint.response.ProductResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl {

    @Autowired
    private RedisTemplate redisTemplate;

    public Product get(String productId){
        String json = (String) redisTemplate.opsForValue().get(productId);
        Product product = new Gson().fromJson(json, Product.class);
        return product;
    }

    public void set(Product product, String id){
        String json = new Gson().toJson(product);
        redisTemplate.opsForValue().set(id, json);
        redisTemplate.expire(id, 60, TimeUnit.SECONDS);
    }

}
