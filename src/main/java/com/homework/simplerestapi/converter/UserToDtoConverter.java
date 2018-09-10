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
public class UserToDtoConverter implements Converter<User, UserData> {

    @Autowired
    private Converter<Article, ArticleData> articleToDtoConverter;

    @Override
    public UserData convert(User source) {
        UserData target = new UserData();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setAge(source.getAge());
        target.setArticles(source.getArticles().stream()
                .map(article -> articleToDtoConverter.convert(article)).collect(Collectors.toList()));

        return target;
    }
}
