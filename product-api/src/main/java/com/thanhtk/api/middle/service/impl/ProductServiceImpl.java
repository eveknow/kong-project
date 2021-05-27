package com.thanhtk.api.middle.service.impl;

import com.thanhtk.api.middle.client.middle.MiddleClientHelper;
import com.thanhtk.api.middle.client.middle.Product;
import com.thanhtk.api.middle.endpoint.request.ProductRequest;
import com.thanhtk.api.middle.endpoint.response.ProductResponse;
import com.thanhtk.api.middle.exception.HandledException;
import com.thanhtk.api.middle.exception.InternalException;
import com.thanhtk.api.middle.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    MiddleClientHelper middleClientHelper;


    private void handleCreateError(){

    }

    @Override
    public Product get(ProductRequest userCreateRequest) throws HandledException {

        try{
            String productId = userCreateRequest.getId();
            CompletableFuture<Product> middleF = middleClientHelper.getProduct(productId);

            Product product = middleF.get();
            return product;

        }catch (Exception e){
            throw new InternalException("Get fail ", e);

        }



    }

}
