package com.thanhtk.api.middle.client.tiki;

import lombok.Data;

@Data
public class TikiProduct {
    String id;
    String name;
    String image;
    Double price;
    Double discount;
}
