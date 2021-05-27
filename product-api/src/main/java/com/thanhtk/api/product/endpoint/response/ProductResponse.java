package com.thanhtk.api.product.endpoint.response;

import com.thanhtk.api.product.client.middle.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Product product;

}
