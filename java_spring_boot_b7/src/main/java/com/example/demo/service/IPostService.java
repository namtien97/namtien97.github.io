package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.User;

import java.util.List;

public interface IPostService {
    List<Post> getAllPostOfUser(User user);
    Post add(Post post);
}
