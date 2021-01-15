package com.techmaster.authen.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.nio.ByteBuffer;
import java.util.*;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    private String id;

    @Column(nullable = false, length = 64)
    private String fullname;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String hashedPassword;

    public User(String fullname, String email, String hashedPassword) {
        this.id = Long.toString(ByteBuffer
                .wrap(UUID.randomUUID().toString().getBytes())
                .getLong(), Character.MAX_RADIX);
        this.fullname = fullname;
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void addTag(Role role){
        roles.add(role);
        role.getUsers().add(this);
    }

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = false)
    @JoinColumn(name = "user_id")
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event event){
        events.add(event);
        event.setUser(this);
    }
}
