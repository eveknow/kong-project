package com.thanhtk.api.middle.client.shopee;

import lombok.Data;

@Data
public class ShopeeProduct {
    String id;
    String name;
    String image;
    Double price;
    Double discount;
}
