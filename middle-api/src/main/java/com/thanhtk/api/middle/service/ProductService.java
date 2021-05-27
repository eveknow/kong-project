package com.thanhtk.api.middle.service;

import com.thanhtk.api.middle.endpoint.request.ProductRequest;
import com.thanhtk.api.middle.endpoint.response.ProductResponse;
import com.thanhtk.api.middle.exception.HandledException;

public interface ProductService {

     ProductResponse get(ProductRequest userCreateRequest) throws HandledException;
}
