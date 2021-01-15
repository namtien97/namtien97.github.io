package com.example.demo.service.impl;

import com.example.demo.controller.request.LoginRequest;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IAuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenService implements IAuthenService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void login(LoginRequest loginRequest) throws AuthenException {
        var user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(loginRequest.getPassword())) {
                throw new AuthenException("Wrong password");
            }
        } else {
            throw new AuthenException("User with email" + loginRequest.getEmail() + "does not exist");
        }
    }
}
