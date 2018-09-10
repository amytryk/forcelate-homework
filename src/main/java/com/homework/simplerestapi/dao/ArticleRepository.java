package com.homework.simplerestapi.dao;

import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article,Long> {

}
