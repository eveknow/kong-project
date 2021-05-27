package com.thanhtk.api.middle.client.lazada;

import com.google.gson.Gson;
import com.thanhtk.api.middle.config.MiddleApiConfig;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

@Service
public class LazadaClientHelper {

    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private MiddleApiConfig middleApiConfig;

    @PostConstruct
    private void init(){
        asyncHttpClient = new DefaultAsyncHttpClient();
    }

    public CompletableFuture<LazadaProduct> getProduct(String productId){
        String url = String.format("%s/%s", middleApiConfig.lazadaUrl, productId);
        CompletableFuture<LazadaProduct> future = asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture()
                .thenApply(
                        res -> {
                            return new Gson().fromJson(res.getResponseBody(), LazadaProduct.class);
                        }
                )
                ;
        return future;


    }

    public static void main(String[] args) {
        AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
        String url = "http://localhost:1006/lazada/13635700";

        try {
            CompletableFuture<LazadaProduct> f = asyncHttpClient
                    .prepareGet(url)
                    .execute()
                    .toCompletableFuture()
                    .thenApply(
                            res -> {
                                return new Gson().fromJson(res.getResponseBody(), LazadaProduct.class);
                            }
                    )
                    ;

            LazadaProduct lazadaProduct = f.get();
            System.out.println("done");
        }catch (Exception e){

        }


    }

}


