package com.thanhtk.api.middle.client.middle;

import com.google.gson.Gson;
import com.thanhtk.api.middle.config.ProductApiConfig;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

@Service
public class MiddleClientHelper {

    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private ProductApiConfig middleApiConfig;

    @PostConstruct
    private void init(){
        asyncHttpClient = new DefaultAsyncHttpClient();
    }

    public CompletableFuture<Product> getProduct(String productId){
        String url = String.format("%s/products/%s", middleApiConfig.middleUrl, productId);
        CompletableFuture<Product> future = asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture()
                .thenApply(
                        res -> {
                            return new Gson().fromJson(res.getResponseBody(), Product.class);
                        }
                )
                ;
        return future;


    }

    public static void main(String[] args) {
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        String url = "http://localhost:1006/lazada/13635700";

        try {
            CompletableFuture<Product> f = asyncHttpClient
                    .prepareGet(url)
                    .execute()
                    .toCompletableFuture()
                    .thenApply(
                            res -> {
                                return new Gson().fromJson(res.getResponseBody(), Product.class);
                            }
                    )
                    ;

            Product lazadaProduct = f.get();
            System.out.println("done");
        }catch (Exception e){

        }


    }

}


