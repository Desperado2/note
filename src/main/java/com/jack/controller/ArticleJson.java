package com.jack.controller;

import com.alibaba.fastjson.JSONObject;
import com.jack.common.Result;
import com.jack.entity.Article;
import com.jack.entity.User;
import com.jack.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("article")
public class ArticleJson {

    @Autowired
    private ArticleService articleService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(Article article,HttpServletRequest request){
        Object user = request.getSession().getAttribute("user");
        article.setAuthorId(user.toString());
        return articleService.save(article);
    }

    @RequestMapping(value = "/list/{page}",method = RequestMethod.GET)
    public Result list(@PathVariable("page") Integer page){
        Long count = articleService.getArticleCount();
        Result result = articleService.getArticleList(page);
        JSONObject object = new JSONObject();
        object.put("count",count);
        object.put("articles",result.getData());
        result.setData(object);
        return result;
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public Result detail(@PathVariable("id") String id){
        return articleService.getArticleById(id);
    }


}
