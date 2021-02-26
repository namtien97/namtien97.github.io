package com.example.demo.service.impl;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
