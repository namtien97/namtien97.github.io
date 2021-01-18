package com.example.demo.model;

import com.example.demo.repository.IUserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "post")
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private LocalDateTime lastUpdate;


    @PrePersist
    public void prePersist(){
        lastUpdate = LocalDateTime.now();
    }
    @PreUpdate //Khi cập nhật record
    public void preUpdate() {
        lastUpdate = LocalDateTime.now();
    }

    public Post(String title,String content){
        this.title=title;
        this.content=content;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "post_id")
    private List<Comment> comments = new ArrayList<>();
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this);
    }
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",nullable = false)
    private User author;
}
