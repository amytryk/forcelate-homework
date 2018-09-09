package com.homework.simplerestapi.service;

import com.homework.simplerestapi.entity.Article;

public interface ArticleService {

    Article save(Article article);
    Article getById(Long id);
}
