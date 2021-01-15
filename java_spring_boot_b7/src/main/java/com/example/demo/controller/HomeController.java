package com.example.demo.controller;

import com.example.demo.controller.request.LoginRequest;
import com.example.demo.security.CookieManager;
import com.example.demo.service.IAuthenService;
import com.example.demo.service.impl.AuthenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Autowired
    private IAuthenService authenService;

    @Autowired private CookieManager cookieManager;

    final String LOGIN_REQUEST = "loginRequest";
    final String LOGIN_TEMPLATE = "login.html";
    final String LOGIN_COOKIE = "loginsuccess";
    final String REDIRECT_POSTS = "redirect:/posts";

    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request) {
        if (cookieManager.getAuthenticatedEmail(request) != null) {
            return Route.REDIRECT_POSTS;
        }
        model.addAttribute(LOGIN_REQUEST, new LoginRequest());
        return Route.LOGIN_TEMPLATE;
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        cookieManager.setNotAuthenticated(response);
        return Route.REDIRECT_HOME;
    }

    @PostMapping("/login")
    public String handleLogin(@ModelAttribute LoginRequest loginRequest,
                              BindingResult bindingResult,
                              Model model,
                              HttpServletResponse response){
        if (!bindingResult.hasErrors()) {
            try {
                authenService.login(loginRequest);
                Cookie loginCookie = new Cookie(LOGIN_COOKIE, loginRequest.getEmail());
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);

                return REDIRECT_POSTS;
            } catch (AuthenException e) {
                model.addAttribute(LOGIN_REQUEST, new LoginRequest(loginRequest.getEmail(), ""));
                model.addAttribute("errorMessage", e.getMessage());
                return LOGIN_TEMPLATE;
            }
        } else {
            model.addAttribute(LOGIN_REQUEST, new LoginRequest());
            model.addAttribute("errorMessage", "Submitted is invalid");
            return LOGIN_TEMPLATE;
        }
    }
}

