package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.security.CookieManager;
import com.example.demo.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {
    @Autowired
    private CookieManager cookieManager;

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getAllPosts(HttpServletRequest request) {
        String loginEmail = cookieManager.getAuthenticatedEmail(request);
        if (loginEmail != null) {
            return Route.ALLPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @GetMapping("/create")
    public String createPost(HttpServletRequest request, Model model) {
        String loginEmail = cookieManager.getAuthenticatedEmail(request);
        if (loginEmail != null) {
            model.addAttribute("newPost", new Post());
            return Route.CREATEPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @PostMapping("/save")
    public String save(Post post, BindingResult result) {
        if (result.hasErrors()) {
            return Route.CREATEPOSTS;
        }
        postService.add(post);
        return Route.REDIRECT_POSTS;
    }
}
