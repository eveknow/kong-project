package com.thanhtk.api.product.endpoint;

import com.google.gson.Gson;
import com.thanhtk.api.product.client.google.GoogleClient;
import com.thanhtk.api.product.client.google.YoutubeAnalyticClient;
import com.thanhtk.api.product.client.google.YoutubeClient;
import com.thanhtk.api.product.client.google.model.GoogleToken;
import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.client.rabbit.ProductEvent;
import com.thanhtk.api.product.client.rabbit.RabbitServiceImpl;
import com.thanhtk.api.product.endpoint.google.model.ChannelAnalyticResponse;
import com.thanhtk.api.product.endpoint.google.model.ChannelResponse;
import com.thanhtk.api.product.endpoint.google.model.SessionResponse;
import com.thanhtk.api.product.endpoint.google.model.YoutubeAnalyticsResponse;
import com.thanhtk.api.product.endpoint.request.ProductRequest;
import com.thanhtk.api.product.endpoint.response.ProductResponse;
import com.thanhtk.api.product.exception.HandledException;
import com.thanhtk.api.product.exception.InternalException;
import com.thanhtk.api.product.log.LogAction;
import com.thanhtk.api.product.log.LogModel;
import com.thanhtk.api.product.log.LogUtil;
import com.thanhtk.api.product.service.ProductService;
import com.thanhtk.api.product.service.ServiceRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

@RestController()
@RequestMapping("/google")
public class GoogleEndpoint {

    @Autowired
    private ServiceRef serviceRef;

    @Autowired
    private ProductService productService;

    @Autowired
    private RabbitServiceImpl rabbitService;

    @Autowired
    private GoogleClient googleClient;

    @Autowired
    private YoutubeClient youtubeClient;

    @Autowired
    private YoutubeAnalyticClient youtubeAnalyticClient;

    private Map<String, GoogleToken> sessionToken = new HashMap<>();


    @GetMapping(value = "")
    public String health() throws HandledException {

        return "OK \n";
    }

    @GetMapping(value = "/login")
    public SessionResponse login(@RequestParam(required=false) Map<String,String> qparams) throws HandledException {

        try {
            if(qparams.get("error") != null){
                throw new Exception(qparams.get("error"));
            }

            String state = qparams.get("state");
            GoogleToken googleToken = googleClient.getToken(qparams.get("code"));

            sessionToken.put(state, googleToken);
            youtubeClient.listChannel(googleToken);
            youtubeAnalyticClient.listChannel(googleToken);
            SessionResponse response = SessionResponse.builder()
                    .sessionId(state)
                    .build();
            return response;
        }catch (Exception e){
            throw new InternalException(e.getMessage());
        }
    }

    @GetMapping(value = "/session")
    public SessionResponse getSession() throws HandledException {

        try {
            String sessionId = "google-" + UUID.randomUUID().toString();
            String redirectUrl = "https://accounts.google.com/o/oauth2/v2/auth?scope=https%3A//www.googleapis.com/auth/youtube.readonly&access_type=offline&include_granted_scopes=true&response_type=code&client_id=11950422477-lb87h7lbrdrj3jbh96ki167e4kn73r9b.apps.googleusercontent.com";


            redirectUrl = redirectUrl + "&state="+sessionId;
            redirectUrl = redirectUrl + "&redirect_uri=https%3A//localhost:4200/google/callback";

            SessionResponse response = SessionResponse.builder()
                    .sessionId(sessionId)
                    .redirectUrl(redirectUrl)
                    .build();
            return response;
        }catch (Exception e){
            throw new InternalException(e.getMessage());
        }
    }


    @GetMapping(value = "/channel")
    public ChannelResponse getChannel(@RequestHeader("sessionId") String sessionId) throws HandledException {

        try {
            GoogleToken googleToken = sessionToken.get(sessionId);
            ChannelResponse channelResponse = youtubeClient.listChannel(googleToken);
            return channelResponse;
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalException(e.getMessage());
        }
    }

    @GetMapping(value = "/channel-analytic")
    public YoutubeAnalyticsResponse getChannelAnalytic(@RequestHeader("sessionId") String sessionId) throws HandledException {

        try {
            GoogleToken googleToken = sessionToken.get(sessionId);
            YoutubeAnalyticsResponse channelResponse = youtubeAnalyticClient.listChannel(googleToken);
            return channelResponse;
        }catch (Exception e){
            throw new InternalException(e.getMessage());
        }
    }

}
