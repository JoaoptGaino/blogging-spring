package com.blogging.blogging.posts;


import com.blogging.blogging.user.User;
import com.blogging.blogging.user.UserDTO;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;
    private String title;
    private String post;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post() {
    }

    public Post(String title, String post, User user) {
        this.title = title;
        this.post = post;
        this.user = user;
    }

    public Post(Long id, String title, String post) {
        this.id = id;
        this.title = title;
        this.post = post;
    }

    public Post(Long id, String title, String post, User user) {
        this.id = id;
        this.title = title;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return new UserDTO(user.getId(),user.getName(),user.getEmail());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
