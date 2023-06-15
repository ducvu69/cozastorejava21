package com.cybersoft.cozastorejava21.service.imp;

import com.cybersoft.cozastorejava21.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
