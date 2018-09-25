package com.jack.service.impl;

import com.jack.common.Result;
import com.jack.dao.ArticleDao;
import com.jack.dao.UserDao;
import com.jack.entity.Article;
import com.jack.service.ArticleService;
import com.jack.utils.IdGenUtil;
import com.jack.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private UserDao userDao;
    @Override
    public Result getArticleList(Integer page) {
        if(page == null || page <= 0){
            return Result.fail("参数错误");
        }
        List<Article> articleList = articleDao.getArticleList(page - 1);

        if(articleList ==  null || articleList.size() ==0){
            return Result.fail("没有查询到内容");
        }
        List<Article> list = new ArrayList<>();
        BeanUtils.copyBean(articleList,list);
        for(Article article : list){
            if(article.getAuthorId() != null){
                article.setAuthorId(userDao.getUserById(article.getAuthorId()).getUsername());
            }
        }
        return Result.success(list);
    }

    @Override
    public Result getArticleById(String id) {
        if(StringUtils.isEmpty(id)){
            return Result.fail("参数错误");
        }
        Article article = articleDao.getArticleById(id);
        if(article == null){
            return Result.fail("没有查询到内容");
        }
        return Result.success(article);
    }

    @Override
    public Result save(Article article) {
        if(article == null){
            return Result.fail("参数错误");
        }
        article.setId(IdGenUtil.getId());
        article.setCommited(0);
        article.setLiked(0);
        article.setReaded(0);
        article.setCreateDate(new Date());
        articleDao.save(article);
        return Result.success(article);
    }

    @Override
    public Long getArticleCount() {
        return articleDao.getArticleCount();
    }
}
