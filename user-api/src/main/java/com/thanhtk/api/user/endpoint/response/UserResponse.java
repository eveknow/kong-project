package com.thanhtk.api.user.endpoint.response;

import lombok.Data;

@Data
public class UserResponse {

    private String userName;
    private String email;
    private String clientId;
    private String clientSecret;

}
