package com.thanhtk.api.product.service.impl;

import com.thanhtk.api.product.client.middle.MiddleClientHelper;
import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.endpoint.request.ProductRequest;
import com.thanhtk.api.product.exception.HandledException;
import com.thanhtk.api.product.exception.InternalException;
import com.thanhtk.api.product.service.ProductService;
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
