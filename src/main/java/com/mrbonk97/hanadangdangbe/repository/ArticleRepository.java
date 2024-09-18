package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findTop10ByOrderByCreatedAtDesc();
}
