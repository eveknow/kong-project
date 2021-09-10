package com.thanhtk.api.product.endpoint.google.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelModel {
    private String kind;
    private String etag;
    private String id;
    Snippet snippet;
    Object contentDetails;
    Statistics statistics;
}
