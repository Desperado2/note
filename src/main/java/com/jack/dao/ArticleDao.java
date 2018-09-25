package com.jack.dao;

import com.jack.entity.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> getArticleList(Integer page);

    Article getArticleById(String id);

    void save(Article article);

    Long getArticleCount();
}
