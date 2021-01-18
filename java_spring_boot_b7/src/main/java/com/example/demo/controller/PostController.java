package com.example.demo.controller;

import com.example.demo.DTO.UserInfo;
import com.example.demo.model.Post;
import com.example.demo.service.IAuthenService;
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
    private IAuthenService authenService;

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getAllPosts(Model model,HttpServletRequest request) {
        UserInfo user = authenService.getLoginedUser(request);
        if (user != null) {
            model.addAttribute("user",user);
            return Route.ALLPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @GetMapping("/create")
    public String createPost(HttpServletRequest request, Model model) {
        UserInfo user = authenService.getLoginedUser(request);
        if (user != null) {
            model.addAttribute("newPost", new Post());
            return Route.CREATEPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @PostMapping("/save")
    public String save(HttpServletRequest request,Post post, BindingResult result) {
        if (result.hasErrors()) {
            return Route.CREATEPOSTS;
        }
        postService.add(post);
        return Route.REDIRECT_POSTS;
    }
}
