package com.example.demo.service;

import com.example.demo.controller.request.LoginRequest;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.impl.AuthenException;

import java.util.List;

public interface IAuthenService {
    public void login(LoginRequest loginRequest) throws AuthenException;
}
