package com.thanhtk.api.user.endpoint;

import com.github.vaibhavsinha.kong.model.admin.consumer.Consumer;
import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.Application;
import com.google.gson.Gson;
import com.thanhtk.api.user.endpoint.request.UserCreateRequest;
import com.thanhtk.api.user.endpoint.response.UserResponse;
import com.thanhtk.api.user.exception.BadRequestException;
import com.thanhtk.api.user.exception.HandledException;
import com.thanhtk.api.user.exception.InternalException;
import com.thanhtk.api.user.log.UserApiLogger;
import com.thanhtk.api.user.service.ServiceRef;
import com.thanhtk.api.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserEndpoint {

    @Autowired
    private ServiceRef serviceRef;

    @Autowired
    private UserService userService;

    public Logger logger = LogManager.getLogger(UserEndpoint.class);

//    @GetMapping(value = "")
//    public String list() throws HandledException {
//        HandledException s =  new BadRequestException("Thanhtk", 300);
//        UserApiLogger.log(s);
//
//        Consumer consumer = new Consumer();
//        consumer.setUsername("thanhtk-test4");
//        try {
////            Consumer consumer1 =
////                    ServiceRef.serviceRef.kongClientHelper.getClient().getConsumerService().createConsumer(consumer);
////
////            Application application = new Application("app", null);
////            ServiceRef.serviceRef.kongClientHelper.getClient().getOAuth2ManageService()
////                    .createConsumerApplication(consumer1.getId(), application);
//
//        }catch (Exception e){
//            e.printStackTrace();
//            UserApiLogger.log(e);
//
//        }
//
//        return "";
//    }


    @PostMapping(value = "")
    public UserResponse create(@RequestBody UserCreateRequest userCreateRequest) throws HandledException {

        try{
            UserResponse userResponse = userService.createUser(userCreateRequest);
            return userResponse;
        }catch (HandledException e){
            logger.error("error ", e);
            throw e;
        }catch (Exception e){
            logger.error("error ", e);
            throw new InternalException();
        }
    }


}
