package com.thanhtk.api.middle.endpoint.response;

import com.thanhtk.api.middle.client.lazada.LazadaProduct;
import com.thanhtk.api.middle.client.shopee.ShopeeProduct;
import com.thanhtk.api.middle.client.tiki.TikiProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private LazadaProduct lazadaProduct;
    private ShopeeProduct shopeeProduct;
    private TikiProduct tikiProduct;

}
