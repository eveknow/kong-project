package com.thanhtk.api.product.validator;

import com.thanhtk.api.product.endpoint.request.ProductRequest;
import com.thanhtk.api.product.exception.BadRequestException;

public class ValidatorService {

    private ValidatorService() {
    }


    public static void validateCreate(ProductRequest userCreateRequest) throws BadRequestException {
        ValidatorUtils.validateName("userName", userCreateRequest.getId(), false);
    }
}
