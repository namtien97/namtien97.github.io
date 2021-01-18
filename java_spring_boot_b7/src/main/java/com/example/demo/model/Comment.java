package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name ="comment")
@Table(name = "comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime lastUpdate;
    @PrePersist
    public void prePersist(){
        lastUpdate = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate(){
        lastUpdate = LocalDateTime.now();
    }

    public Comment(String content){
        this.content = content;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User commenter;

    public void setCommenter(User user){
        user.getComments().add(this);
        this.commenter=user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
}
