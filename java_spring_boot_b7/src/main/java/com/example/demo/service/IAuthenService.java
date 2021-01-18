package com.example.demo.service;

import com.example.demo.DTO.UserInfo;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.impl.AuthenException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IAuthenService {
    public UserInfo login(LoginRequest loginRequest) throws AuthenException;

    public boolean isLogined(HttpServletRequest request);

    public UserInfo getLoginedUser(HttpServletRequest request);

    public void setLoginedCookie(HttpServletResponse response, UserInfo user);

    public void clearLoginedCookie(HttpServletResponse response);
}
