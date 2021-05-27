package com.thanhtk.service.tracking.validator;

import com.thanhtk.service.tracking.endpoint.request.ProductRequest;
import com.thanhtk.service.tracking.exception.BadRequestException;

public class ValidatorService {

    private ValidatorService() {
    }


    public static void validateCreate(ProductRequest userCreateRequest) throws BadRequestException {
        ValidatorUtils.validateName("userName", userCreateRequest.getId(), false);
    }
}
