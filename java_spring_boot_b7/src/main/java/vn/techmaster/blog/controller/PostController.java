package vn.techmaster.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.controller.request.CommentRequest;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Optional;


@Controller
public class PostController {
    @Autowired
    private IAuthenService authenService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public String getAllPosts(Model model, HttpServletRequest request) {
        UserInfo user = authenService.getLoginedUser(request);
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("posts", postService.getAllPostOfUser(user));
            return Route.ALLPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @GetMapping("/create")
    public String createPost(HttpServletRequest request, Model model) {
        UserInfo user = authenService.getLoginedUser(request);
        if (user != null) {
            model.addAttribute("post", new Post());
            return Route.CREATEPOSTS;
        } else {
            return Route.REDIRECT_HOME;
        }
    }

    @PostMapping("/save")
    public String save(Post post, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return Route.CREATEPOSTS;
        }
        UserInfo user = authenService.getLoginedUser(request);
        Optional<User> userMapper = userRepository.findByEmail(user.getEmail());
        if (userMapper.isPresent()) {
            post.setAuthor(userMapper.get());
            if(post.getId()!=null){
                post.setLastUpdate(LocalDateTime.now());
                postService.update(post);
            }else{
                userMapper.get().addPost(post);
                postService.add(post);
            }
        }
        return Route.REDIRECT_POSTS;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id, HttpServletRequest request) {
        UserInfo user = authenService.getLoginedUser(request);
        Optional<User> userMapper = userRepository.findByEmail(user.getEmail());
        Post post = postService.getPostById(id);
        if (userMapper.isPresent()) {
            userMapper.get().removePost(post);
        }
        postService.removePost(id);
        return Route.REDIRECT_POSTS;
    }

    @GetMapping("/edit/{id}")
    public String editById(@PathVariable("id") Long id, HttpServletRequest request,Model model) {
        UserInfo user = authenService.getLoginedUser(request);
        Optional<User> userMapper = userRepository.findByEmail(user.getEmail());
        Post post = postService.getPostById(id);
        if (userMapper.isPresent() && post != null) {
            model.addAttribute("post",post);
        }
        return Route.CREATEPOSTS;
    }

    @GetMapping(value = "/post/{id}")
    public String getByID(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            model.addAttribute("comments",postRepository.findById(id).get().getComments());
            model.addAttribute("commentRequest", new CommentRequest());
        }
        return Route.POST;
    }
}
