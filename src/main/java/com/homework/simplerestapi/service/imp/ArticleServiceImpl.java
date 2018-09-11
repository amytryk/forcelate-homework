package com.homework.simplerestapi.service.imp;

import com.homework.simplerestapi.dao.ArticleRepository;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.exception.ArticleNotFoundException;
import com.homework.simplerestapi.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getById(Long id) {
        Optional<Article> result = articleRepository.findById(id);

        return result.orElseThrow(() -> new ArticleNotFoundException("Could not find article by id " + id));
    }
}
