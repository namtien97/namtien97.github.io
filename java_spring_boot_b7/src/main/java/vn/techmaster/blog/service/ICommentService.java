package vn.techmaster.blog.service;

import vn.techmaster.blog.model.Comment;
import vn.techmaster.blog.model.Post;

import java.util.List;

public interface ICommentService {
    Comment add (Comment comment);
    List<Comment> getAllComment();
}
