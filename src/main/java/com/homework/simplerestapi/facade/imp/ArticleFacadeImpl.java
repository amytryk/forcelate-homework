package com.homework.simplerestapi.facade.imp;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.facade.ArticleFacade;
import com.homework.simplerestapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleFacadeImpl implements ArticleFacade {

    @Autowired
    private ArticleService articleService;

    @Override
    public ArticleData save(ArticleData articleData) {
        Article article = new Article();
        article.setText(articleData.getText());
        article.setColor(articleData.getColor());

        Article savedArticle = articleService.save(article);
        articleData.setId(savedArticle.getId());
        return articleData;
    }

    @Override
    public ArticleData getById(Long id) {
        Article article = articleService.getById(id);

        ArticleData articleData = new ArticleData();
        articleData.setId(article.getId());
        articleData.setText(article.getText());
        articleData.setColor(article.getColor());
        return articleData;
    }

}
