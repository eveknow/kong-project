package com.thanhtk.api.middle.client.middle;

import lombok.Data;

@Data
public class ShopeeProduct {
    String id;
    String name;
    String image;
    Double price;
    Double discount;
}
