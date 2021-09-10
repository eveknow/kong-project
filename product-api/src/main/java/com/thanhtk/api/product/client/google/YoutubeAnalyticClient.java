package com.thanhtk.api.product.client.google;

import com.google.gson.Gson;
import com.thanhtk.api.product.client.google.model.GoogleToken;
import com.thanhtk.api.product.client.restclient.RestTemplateService;
import com.thanhtk.api.product.endpoint.google.model.YoutubeAnalyticsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class YoutubeAnalyticClient {

    @Autowired
    private RestTemplateService restTemplateService;

    public YoutubeAnalyticsResponse listChannel(GoogleToken googleToken) throws Exception {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://youtubeanalytics.googleapis.com/v2/reports")
                .queryParam("dimensions", "video")
                .queryParam("endDate", "2022-05-01")
                .queryParam("startDate", "2021-05-01")
                .queryParam("ids", "channel==MINE")
                .queryParam("maxResults", 10)
                .queryParam("metrics", "estimatedMinutesWatched,views,likes,subscribersGained")
                .queryParam("sort", "-estimatedMinutesWatched")
                ;

        String url = builder.build(false).toUriString();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(googleToken.getAccess_token());
        HttpEntity formEntity = new HttpEntity<MultiValueMap<String, String>>(null, httpHeaders);

        ResponseEntity<String> response = restTemplateService.restTemplate.exchange(url,HttpMethod.GET, formEntity, String.class);
        if(response.getStatusCode().is2xxSuccessful()){
            YoutubeAnalyticsResponse youtubeAnalyticsResponse =
                    new Gson().fromJson(response.getBody(), YoutubeAnalyticsResponse.class);
            return youtubeAnalyticsResponse;
        }
        throw new Exception(response.getBody());
    }

    public static void main(String[] args) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://youtubeanalytics.googleapis.com/v2/reports")
                .queryParam("dimensions", "video")
                .queryParam("endDate", "2022-05-01")
                .queryParam("startDate", "2021-05-01")
                .queryParam("ids", "channel==MINE")
                .queryParam("maxResults", 10)
                .queryParam("metrics", "estimatedMinutesWatched,views,likes,subscribersGained")
                .queryParam("sort", "-estimatedMinutesWatched")
                ;

        String url = builder.toUriString();
        System.out.println(url);


    }

}
