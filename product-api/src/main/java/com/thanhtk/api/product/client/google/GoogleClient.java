package com.thanhtk.api.product.client.google;

import com.google.gson.Gson;
import com.thanhtk.api.product.client.google.model.GoogleToken;
import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.client.restclient.RestTemplateService;
import com.thanhtk.api.product.config.ProductApiConfig;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class GoogleClient {
    private AsyncHttpClient asyncHttpClient;

    @Autowired
    private ProductApiConfig middleApiConfig;

    @Autowired
    private RestTemplateService restTemplateService;

    public GoogleToken getToken(String code) throws Exception {
        asyncHttpClient = new DefaultAsyncHttpClient();
        String clientId = "11950422477-lb87h7lbrdrj3jbh96ki167e4kn73r9b.apps.googleusercontent.com";
        String clientSecret = "DbfKP4ShGCiSsI_prQowsdXJ";
        String redirectUrl = "https://localhost:4200/google/callback";
        String grantType = "authorization_code";
        String url = "https://oauth2.googleapis.com/token";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> hashMap = new LinkedMultiValueMap<>();
        hashMap.add("client_id", clientId);
        hashMap.add("client_secret", clientSecret);
        hashMap.add("redirect_uri", redirectUrl);
        hashMap.add("grant_type", grantType);
        hashMap.add("code", code);

        HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(hashMap, httpHeaders);

//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplateService.restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, formEntity, String.class);
//        System.out.println("response" + response);
        if(response.getStatusCode().is2xxSuccessful()){
            GoogleToken googleToken = new Gson().fromJson(response.getBody(), GoogleToken.class);
            return googleToken;
        }
        throw new Exception(response.getBody());

    }

    public static void main(String[] args) throws Exception {
        GoogleClient googleClient = new GoogleClient();
        GoogleToken a = googleClient.getToken("4/0AX4XfWhG-iNI9qWLCch2WgiwneGTnXzuqzU7x_JjeOMv62U0c5Nr-DXoo0WgIjOWN7vIbw");
        System.out.println("a");
    }

}
