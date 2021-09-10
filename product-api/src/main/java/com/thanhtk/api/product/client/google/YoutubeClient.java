package com.thanhtk.api.product.client.google;

import com.google.gson.Gson;
import com.thanhtk.api.product.client.google.model.GoogleToken;
import com.thanhtk.api.product.client.restclient.RestTemplateService;
import com.thanhtk.api.product.endpoint.google.model.ChannelResponse;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class YoutubeClient {

    @Autowired
    private RestTemplateService restTemplateService;

    public ChannelResponse listChannel(GoogleToken googleToken) throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://youtube.googleapis.com/youtube/v3/channels")
                .queryParam("part", "snippet", "contentDetails", "statistics")
                .queryParam("mine", true);

        String url = builder.toUriString();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(googleToken.getAccess_token());
        HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(null, httpHeaders);

        ResponseEntity<String> response = restTemplateService.restTemplate.exchange(url,HttpMethod.GET, formEntity, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            ChannelResponse channelResponse =new Gson().fromJson(response.getBody(), ChannelResponse.class);
            return channelResponse;
        }
        throw new Exception(response.getBody());
    }

}
