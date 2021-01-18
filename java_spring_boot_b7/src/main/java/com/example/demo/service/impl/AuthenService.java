package com.example.demo.service.impl;

import com.example.demo.DTO.IUserMapper;
import com.example.demo.DTO.UserInfo;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IAuthenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
public class AuthenService implements IAuthenService {
    @Autowired
    private IUserRepository userRepository;

    private static final String LOGIN_COOKIE = "loginsuccess";

    @Override
    public UserInfo login(LoginRequest loginRequest) throws AuthenException {
        var user = userRepository.findByEmail(loginRequest.getEmail());
        if (user.isPresent()) {
            if (!user.get().getPassword().equals(loginRequest.getPassword())){
                throw new AuthenException("Wrong password");
            } else {
                return IUserMapper.INSTANCE.userToUserInfo(user.get());
            }
        } else {
            throw new AuthenException("User with email " + loginRequest.getEmail() + " does not exist");
        }
    }

    @Override
    public boolean isLogined(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (var cookie:cookies) {
                if (cookie.getName().equals(LOGIN_COOKIE)) {
                    long userId =  Long.parseLong(cookie.getValue());
                    Optional<User> user = userRepository.findById(userId);
                    return user.isPresent();
                }
            }
        }
        return false;
    }

    @Override
    public UserInfo getLoginedUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (var cookie:cookies) {
                if (cookie.getName().equals(LOGIN_COOKIE)) {
                    long userId =  Long.parseLong(cookie.getValue());
                    Optional <User> user = userRepository.findById(userId);
                    if (user.isPresent()) {
                        return IUserMapper.INSTANCE.userToUserInfo(user.get());
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void setLoginedCookie(HttpServletResponse response, UserInfo user) {
        Cookie loginCookie = new Cookie(LOGIN_COOKIE, String.valueOf(user.getId()));
        loginCookie.setMaxAge(30 * 60);
        loginCookie.setPath("/");
        response.addCookie(loginCookie);
    }

    @Override
    public void clearLoginedCookie(HttpServletResponse response) {
        Cookie loginCookie = new Cookie(LOGIN_COOKIE, null);
        loginCookie.setMaxAge(0);
        loginCookie.setHttpOnly(true);
        loginCookie.setPath("/");
        //add cookie to response
        response.addCookie(loginCookie);
    }


}
