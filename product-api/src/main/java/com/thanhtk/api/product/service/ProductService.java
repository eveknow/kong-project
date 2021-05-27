package com.thanhtk.api.product.service;

import com.thanhtk.api.product.client.middle.Product;
import com.thanhtk.api.product.endpoint.request.ProductRequest;
import com.thanhtk.api.product.exception.HandledException;

public interface ProductService {

     Product get(ProductRequest userCreateRequest) throws HandledException;
}
