package vn.techmaster.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vn.techmaster.blog.service.IPostService;
import vn.techmaster.blog.service.ISecurityService;

@Component
public class BlogAppRunner implements CommandLineRunner {
    @Autowired
    IPostService postService;

    @Autowired
    ISecurityService securityService;

    @Override
    public void run(String... args) throws Exception {
        securityService.generateUserRoles();
        postService.generateSampleData();
    }
}
