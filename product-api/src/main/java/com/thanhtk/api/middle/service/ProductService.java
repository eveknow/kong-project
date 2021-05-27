package com.thanhtk.api.middle.service;

import com.thanhtk.api.middle.client.middle.Product;
import com.thanhtk.api.middle.endpoint.request.ProductRequest;
import com.thanhtk.api.middle.endpoint.response.ProductResponse;
import com.thanhtk.api.middle.exception.HandledException;

public interface ProductService {

     Product get(ProductRequest userCreateRequest) throws HandledException;
}
