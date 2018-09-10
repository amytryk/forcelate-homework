package com.homework.simplerestapi.converter;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.entity.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DtoToArticleConverter implements Converter<ArticleData, Article> {

    @Override
    public Article convert(ArticleData source) {
        Article target = new Article();
        target.setText(source.getText());
        target.setColor(source.getColor());

        return target;
    }
}
