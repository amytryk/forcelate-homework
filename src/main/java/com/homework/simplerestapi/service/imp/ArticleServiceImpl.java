package com.homework.simplerestapi.service.imp;

import com.homework.simplerestapi.dao.ArticleRepository;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.exception.ArticleNotFoundException;
import com.homework.simplerestapi.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) {
        Optional<Article> result = articleRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ArticleNotFoundException("Could not find article by id " + id);
    }
}
