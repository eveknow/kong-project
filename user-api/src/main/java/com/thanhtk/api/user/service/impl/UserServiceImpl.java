package com.thanhtk.api.user.service.impl;

import com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2.Application;
import com.thanhtk.api.user.client.kong.KongClientHelper;
import com.thanhtk.api.user.db.entity.AccountEntity;
import com.thanhtk.api.user.db.entity.AccountOauthEntity;
import com.thanhtk.api.user.db.repo.AccountOauthRepository;
import com.thanhtk.api.user.db.repo.AccountRepository;
import com.thanhtk.api.user.endpoint.request.UserCreateRequest;
import com.thanhtk.api.user.endpoint.response.UserResponse;
import com.thanhtk.api.user.exception.HandledException;
import com.thanhtk.api.user.exception.InternalException;
import com.thanhtk.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private KongClientHelper kongClientHelper;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountOauthRepository accountOauthRepository;


    private void handleCreateError(AccountEntity accountEntity, AccountOauthEntity accountOauthEntity){

    }

    @Override
    public UserResponse createUser(UserCreateRequest userCreateRequest) throws HandledException {

        UserResponse userResponse = new UserResponse();
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(userCreateRequest.getUserName());
        accountEntity.setPassword(userCreateRequest.getPassword());
        accountEntity.setId(UUID.randomUUID().toString());
        accountRepository.save(accountEntity);
        AccountOauthEntity accountOauthEntity = new AccountOauthEntity();

        try{
            String id = kongClientHelper.createConsumer(userCreateRequest.getUserName());
            accountOauthEntity.setConsumerId(id);
            accountOauthEntity.setAccountId(accountEntity.getId());
            Application application = kongClientHelper.createConsumerOauth(id);
            accountOauthEntity.setClientId(application.getClientId());
            accountOauthEntity.setClientSecret(application.getClientSecret());
            accountOauthRepository.save(accountOauthEntity);
            userResponse.setUserName(accountEntity.getName());
            userResponse.setClientId(accountOauthEntity.getClientId());
            userResponse.setClientSecret(accountOauthEntity.getClientSecret());
            return userResponse;
        }catch (Exception e){
            handleCreateError(accountEntity, accountOauthEntity);
            throw new InternalException("createUser error", e);
        }

    }

}
