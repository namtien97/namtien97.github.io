package vn.techmaster.blog.service;

import java.util.List;

import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.model.Post;

public interface iPostService {
  List<Post> getAllPostOfUser(UserInfo user);
  Post getPostById(Long id);
  Post add(Post post);
  void removePost(Long id);
  void update(Post post);
}
