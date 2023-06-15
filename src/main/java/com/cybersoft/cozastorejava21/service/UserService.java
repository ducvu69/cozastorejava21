package com.cybersoft.cozastorejava21.service;

import com.cybersoft.cozastorejava21.entity.UserEntity;
import com.cybersoft.cozastorejava21.payload.request.SignupRequest;
import com.cybersoft.cozastorejava21.repository.UserRepository;
import com.cybersoft.cozastorejava21.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try{
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){

        }
        return isSuccess;
    }
}
