package com.thanhtk.api.product.client.middle;

import lombok.Data;

@Data
public class TikiProduct {
    String id;
    String name;
    String image;
    Double price;
    Double discount;
}
