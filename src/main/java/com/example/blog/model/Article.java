package com.example.blog.model;

public class Article {

    private Long id;
    private String title;
    private String date;
    private String content;
    private String imageUrl;

    public Article() {
    }

    public Article(Long id, String title, String date, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
        this.imageUrl = imageUrl;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}