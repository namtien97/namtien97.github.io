package com.example.demo.service.impl;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.IPostRepository;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> getAllPostOfUser(User user) {
        return null;
    }

    @Override
    public Post add(Post post) {
        return postRepository.saveAndFlush(post);
    }
}



