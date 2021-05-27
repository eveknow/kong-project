package com.thanhtk.api.middle.client.middle;

import lombok.Data;

@Data
public class Product {
    LazadaProduct lazadaProduct;
    ShopeeProduct shopeeProduct;
    TikiProduct tikiProduct;
}
