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
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.CommentRepository;
import vn.techmaster.blog.repository.PostRepository;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.service.IAuthenService;
import vn.techmaster.blog.service.ICommentService;
import vn.techmaster.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {

    @Autowired
    private IAuthenService authenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/createComment/{id}")
    public String createComment(@PathVariable("id") Long id, HttpServletRequest request, Model model) {
        UserInfo user = authenService.getLoginedUser(request);
        Optional<User> userMapper = userRepository.findByEmail(user.getFullname());
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment());
        return Route.CREATE_COMMENT;
    }

    @PostMapping("/saveComment/{id}")
    public String saveComment(@PathVariable("id") Long id, CommentRequest commentRequest, BindingResult result, HttpServletRequest request, Model model) {
        Comment newComment = new Comment();
        if (result.hasErrors()) {
            return Route.REDIRECT_POST;
        }
        UserInfo user = authenService.getLoginedUser(request);
        Optional<User> userMapper = userRepository.findByEmail(user.getEmail());
        Post post = postService.getPostById(id);
        if (userMapper.isPresent()) {
            newComment.setCommenter(userMapper.get());
            newComment.setPost(post);
            newComment.setContent(commentRequest.getContent());

            post.addComment(newComment);

            commentService.add(newComment);
        }
        return Route.REDIRECT_POSTS;
    }

    @GetMapping("/deleteComment/{idPost}/{idComment}")
    public String deleteComment(@PathVariable("idComment") Long idComment, @PathVariable("idPost") Long idPost,HttpServletRequest request){
        UserInfo user = authenService.getLoginedUser(request);
        Optional<Post> post =postRepository.findById(idPost);
        Optional<User> userMapper = userRepository.findByEmail(user.getEmail());
        Optional<Comment> comment = commentRepository.findById(idComment);
        if(userMapper.isPresent()){
           /* userMapper.get().removeComment(comment.get());
            post.get().removeComment(comment.get());*/
            commentRepository.deleteById(idComment);
        }
        return Route.REDIRECT_POSTS;
    }
}
