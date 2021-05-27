package com.thanhtk.api.middle.validator;

import com.thanhtk.api.middle.endpoint.request.ProductRequest;
import com.thanhtk.api.middle.exception.BadRequestException;

public class ValidatorService {

    private ValidatorService() {
    }


    public static void validateCreate(ProductRequest userCreateRequest) throws BadRequestException {
        ValidatorUtils.validateName("userName", userCreateRequest.getId(), false);
    }
}
