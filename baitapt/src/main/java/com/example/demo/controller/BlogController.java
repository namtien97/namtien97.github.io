package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IPostService postService;

    @GetMapping("/blog")
    public String getBlogPage(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("listPost",posts);
        return "shop/blog";
    }
}
