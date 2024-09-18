package com.mrbonk97.hanadangdangbe.controller;

import com.mrbonk97.hanadangdangbe.model.Article;
import com.mrbonk97.hanadangdangbe.service.ArticleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/recent")
    public ResponseEntity<List<Article>> getRecentArticles() {
        return ResponseEntity.ok(articleService.findRecentTenArticle());
    }
}
