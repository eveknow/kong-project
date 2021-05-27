package com.thanhtk.api.middle.client.lazada;

import lombok.Data;

@Data
public class LazadaProduct {
    String id;
    String name;
    String image;
    Double price;
    Double discount;
}
