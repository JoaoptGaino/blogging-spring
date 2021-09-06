package com.blogging.blogging.posts;

public class PostDTO {

    private Long id;
    private String title;
    private String post;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String post) {
        this.id = id;
        this.title = title;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
