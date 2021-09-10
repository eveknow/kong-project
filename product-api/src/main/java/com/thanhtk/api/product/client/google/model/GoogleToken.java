package com.thanhtk.api.product.client.google.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoogleToken {
    private String access_token;
    private float expires_in;
    private String token_type;
    private String scope;
    private String refresh_token;
}
