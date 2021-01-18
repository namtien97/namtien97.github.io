package vn.techmaster.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.DTO.UserInfo;
import vn.techmaster.blog.model.Post;
import vn.techmaster.blog.repository.PostRepository;

import java.util.List;

@Service
public class PostService implements iPostService {

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<Post> getAllPostOfUser(UserInfo user) {
    return postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.getOne(id);
  }

  @Override
  public Post add(Post post) {
    return postRepository.save(post);
  }

  @Override
  public void removePost(Long id) {
    postRepository.deleteById(id);
  }

  @Override
  public void update(Post post) {
    Post postUpdate = post;
    postUpdate.setContent(post.getContent());
    postUpdate.setLastUpdate(postUpdate.getLastUpdate());
    postUpdate.setTitle(postUpdate.getTitle());
    postUpdate.setAuthor(post.getAuthor());
    postRepository.save(postUpdate);
  }

}
