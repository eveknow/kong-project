package com.thanhtk.api.middle.client.shopee;

import com.google.gson.Gson;
import com.thanhtk.api.middle.client.lazada.LazadaProduct;
import com.thanhtk.api.middle.config.MiddleApiConfig;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

@Service
public class ShopeeClientHelper {

    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private MiddleApiConfig middleApiConfig;

    @PostConstruct
    private void init(){
        asyncHttpClient = new DefaultAsyncHttpClient();
    }

    public CompletableFuture<ShopeeProduct> getProduct(String productId){
        String url = String.format("%s/%s", middleApiConfig.shopeeUrl, productId);
        CompletableFuture<ShopeeProduct> future = asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture()
                .thenApply(
                        res -> {
                            return new Gson().fromJson(res.getResponseBody(), ShopeeProduct.class);
                        }
                )
                ;
        return future;


    }


}


