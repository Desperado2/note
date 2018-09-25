package com.jack.service;

import com.jack.common.Result;
import com.jack.entity.Article;

import java.util.List;

public interface ArticleService {
    Result getArticleList(Integer page);

    Result getArticleById(String id);

    Result save(Article article);

    Long getArticleCount();
}
