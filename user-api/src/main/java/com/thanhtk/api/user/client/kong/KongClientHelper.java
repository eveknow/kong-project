package com.thanhtk.api.user.client.kong;

import com.github.vaibhavsinha.kong.impl.KongClient;
import com.github.vaibhavsinha.kong.model.admin.consumer.Consumer;
import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.Application;
import com.thanhtk.api.user.config.UserApiConfig;
import com.thanhtk.api.user.exception.HandledException;
import com.thanhtk.api.user.exception.InternalException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class KongClientHelper {

    private KongClient kongClient;

    @PostConstruct
    private void init(){
        kongClient = new KongClient(UserApiConfig.getInstanceRef().kongAdminUrl,
                UserApiConfig.getInstanceRef().kongProxyUrl,
                true);
    }

    public String createConsumer(String userName) throws HandledException{
        try {
            Consumer consumer = new Consumer();
            consumer.setUsername(userName);
            consumer = kongClient.getConsumerService().createConsumer(consumer);
            return consumer.getId();
        }catch (Exception e){
            throw new InternalException("createConsumer error", 500);
        }

    }

    public Application createConsumerOauth(String consumerId) throws HandledException{
        try {
            Application application = new Application("App", null);
            application = kongClient.getOAuth2ManageService().createConsumerApplication(consumerId, application);
            return application;
        }catch (Exception e){
            throw new InternalException("createConsumerOauth error", 500);
        }

    }

//    public static void main(String[] args) {
//        KongClient kongClient = new KongClient("http://localhost:1003",
//                "https://localhost:1001",
//                true);
//        List<String> re = new ArrayList<>();
//        re.add("https://localhost");
//        Application application = new Application("thanhtk1", re);
//        kongClient.getOAuth2ManageService().createConsumerApplication("603ec921-4547-4e7e-ba25-445f20f1f292", application);
//    }

}
