package com.thanhtk.api.middle.service.impl;

import com.thanhtk.api.middle.client.lazada.LazadaClientHelper;
import com.thanhtk.api.middle.client.lazada.LazadaProduct;
import com.thanhtk.api.middle.client.shopee.ShopeeClientHelper;
import com.thanhtk.api.middle.client.shopee.ShopeeProduct;
import com.thanhtk.api.middle.client.tiki.TikiClientHelper;
import com.thanhtk.api.middle.client.tiki.TikiProduct;
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
    LazadaClientHelper lazadaClientHelper;

    @Autowired
    ShopeeClientHelper shopeeClientHelper;

    @Autowired
    TikiClientHelper tikiClientHelper;


    private void handleCreateError(){

    }

    @Override
    public ProductResponse get(ProductRequest userCreateRequest) throws HandledException {

        try{
            String productId = userCreateRequest.getId();
            CompletableFuture<LazadaProduct> lazadaF = lazadaClientHelper.getProduct(productId);
            CompletableFuture<ShopeeProduct> shopeeF = shopeeClientHelper.getProduct(productId);
            CompletableFuture<TikiProduct> tikiF = tikiClientHelper.getProduct(productId);

            CompletableFuture<Void> combinedFuture
                    = CompletableFuture.allOf(lazadaF, shopeeF, tikiF);
            combinedFuture.get();
            ProductResponse productResponse = new ProductResponse(lazadaF.get(), shopeeF.get(), tikiF.get());
            return productResponse;

        }catch (Exception e){
            throw new InternalException("Get fail ", e);

        }



    }

}
