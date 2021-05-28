package com.thanhtk.api.product.client.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEvent {
    String userName;
    String productId;
}
