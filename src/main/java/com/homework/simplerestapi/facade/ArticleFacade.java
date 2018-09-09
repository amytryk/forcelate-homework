package com.homework.simplerestapi.facade;

import com.homework.simplerestapi.data.ArticleData;

public interface ArticleFacade {
    ArticleData save(ArticleData articleData);
    ArticleData getById(Long id);

}
