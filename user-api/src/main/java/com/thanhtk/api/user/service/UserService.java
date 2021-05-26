package com.thanhtk.api.user.service;

import com.thanhtk.api.user.endpoint.request.UserCreateRequest;
import com.thanhtk.api.user.endpoint.response.UserResponse;
import com.thanhtk.api.user.exception.HandledException;

public interface UserService {

     UserResponse createUser(UserCreateRequest userCreateRequest) throws HandledException;
}
