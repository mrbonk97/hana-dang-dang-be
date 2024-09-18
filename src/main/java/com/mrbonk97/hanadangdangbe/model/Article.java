package com.mrbonk97.hanadangdangbe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 8192)
    private String content;
    private String imageUrl;
    private String originalUrl;
    private Date createdAt;
    private Date updatedAt;

    @PrePersist
    public void createArticle() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void updateArticle() {
        this.updatedAt = new Date();
    }
}
