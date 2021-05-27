package com.thanhtk.api.middle.endpoint.response;

import com.thanhtk.api.middle.client.middle.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Product product;

}
