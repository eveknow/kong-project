package com.thanhtk.api.user.validator;

import com.thanhtk.api.user.endpoint.request.UserCreateRequest;
import com.thanhtk.api.user.exception.BadRequestException;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

public class ValidatorService {

    private ValidatorService() {
    }


    public static void validateCreate(UserCreateRequest userCreateRequest) throws BadRequestException {
        ValidatorUtils.validateName("userName", userCreateRequest.getUserName(), false);
    }
}
