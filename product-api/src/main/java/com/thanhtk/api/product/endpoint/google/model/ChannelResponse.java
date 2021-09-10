package com.thanhtk.api.product.endpoint.google.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChannelResponse {
    private String kind;
    private String etag;
    PageInfo PageInfoObject;
    ArrayList< ChannelModel > items = new ArrayList < ChannelModel > ();
}
