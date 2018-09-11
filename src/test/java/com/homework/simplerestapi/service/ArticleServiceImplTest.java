package com.homework.simplerestapi.service;

import com.homework.simplerestapi.dao.ArticleRepository;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;
import com.homework.simplerestapi.service.imp.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArticleServiceImplTest {

    private ArticleService articleService;
    private ArticleRepository articleRepositoryMock;

    @Before
    public void setUp() {
        articleRepositoryMock = mock(ArticleRepository.class);
        articleService = new ArticleServiceImpl(articleRepositoryMock);

        Article article = new Article();
        article.setId(1L);
        article.setText("testArticle");
        article.setColor(Color.GOLDEN);
        article.setUser(new User());

        when(articleRepositoryMock.save(any(Article.class))).thenReturn(article);
        when(articleRepositoryMock.findById(1L)).thenReturn(Optional.of(article));
    }

    @Test
    public void save(){
        Article savedArticle = articleService.save(mock(Article.class));

        assertThat(savedArticle).isNotNull();
        assertThat(savedArticle.getId()).isNotNull();
        assertThat(savedArticle.getText()).isEqualTo("testArticle");
        assertThat(savedArticle.getColor()).isEqualTo(Color.GOLDEN);
        assertThat(savedArticle.getUser()).isNotNull();
    }

    @Test
    public void getById(){
        Article article = articleService.getById(1L);
        assertThat(article).isNotNull();
    }

}
