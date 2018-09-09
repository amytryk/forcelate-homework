package com.homework.simplerestapi.dao;

import com.homework.simplerestapi.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
