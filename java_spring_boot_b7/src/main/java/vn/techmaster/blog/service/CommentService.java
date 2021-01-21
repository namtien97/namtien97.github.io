package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService implements ICommentService{

    public static final String FIND_PROJECTS = "SELECT * FROM COMMENT WHERE POST_ID = ?";

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment add(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }
    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }
}
