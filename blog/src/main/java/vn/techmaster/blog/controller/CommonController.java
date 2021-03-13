package vn.techmaster.blog.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class CommonController {
    @GetMapping("/perform_custom_logout")
    public String performLogout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();

        if(session !=null){
            session.invalidate();
        }
        for (Cookie cookie: request.getCookies()
             ) {
            cookie.setMaxAge(0);
        }
        return "logout";
    }

    @GetMapping("/login_success")
    public String showLoginSuccess(Principal principal, Model model){
        String loginName = (principal != null) ? principal.getName() : "";

        var authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        model.addAttribute("login_name", loginName);
        model.addAttribute("authorities", authorities);
        return "login_success";
    }
}
