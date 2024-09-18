package com.mrbonk97.hanadangdangbe.service;

import com.mrbonk97.hanadangdangbe.model.Article;
import com.mrbonk97.hanadangdangbe.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> findRecentTenArticle() {
        return articleRepository.findTop10ByOrderByCreatedAtDesc();
    }




}
