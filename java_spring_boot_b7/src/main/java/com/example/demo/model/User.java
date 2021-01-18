package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private long id;

    @Column(nullable = false, length = 64)
    private String fullname;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private List<Post> posts = new ArrayList<>();
    public void addPost(Post post) {
        posts.add(post);
        post.setAuthor(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setAuthor(null);
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private List<Comment> comments = new ArrayList<>();
    /*public void addComment(Comment comment) {
        comments.add(comment);
        comment.setCommenter(this);
    }*/
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setCommenter(null);
    }
}
