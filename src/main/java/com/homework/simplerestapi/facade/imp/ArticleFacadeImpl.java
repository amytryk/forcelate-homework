package com.homework.simplerestapi.facade.imp;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.facade.ArticleFacade;
import com.homework.simplerestapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleFacadeImpl implements ArticleFacade {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private Converter<ArticleData, Article> dtoToArticleConverter;

    @Autowired
    private Converter<Article, ArticleData> articleToDtoConverter;

    @Override
    public ArticleData save(ArticleData articleData) {
        Article article = dtoToArticleConverter.convert(articleData);

        Article savedArticle = articleService.save(article);
        return articleToDtoConverter.convert(savedArticle);
    }

    @Override
    public ArticleData getById(Long id) {
        Article article = articleService.getById(id);

        return articleToDtoConverter.convert(article);
    }

}
