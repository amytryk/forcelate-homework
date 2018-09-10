package com.homework.simplerestapi.converter;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.entity.Article;
import com.homework.simplerestapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DtoToUserConverter implements Converter<UserData, User> {

    @Autowired
    private Converter<ArticleData, Article> dtoToArticleConverter;

    @Override
    public User convert(UserData source) {
        User target = new User();
        target.setName(source.getName());
        target.setAge(source.getAge());
        target.setArticles(source.getArticles().stream()
                .map(articleData -> {
                    Article article = dtoToArticleConverter.convert(articleData);
                    article.setUser(target);
                    return article;
                })
                .collect(Collectors.toList()));

        return target;
    }
}
