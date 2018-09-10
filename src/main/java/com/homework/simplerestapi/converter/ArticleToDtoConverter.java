package com.homework.simplerestapi.converter;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.entity.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleToDtoConverter implements Converter<Article, ArticleData> {

    @Override
    public ArticleData convert(Article source) {
        ArticleData target = new ArticleData();
        target.setId(source.getId());
        target.setText(source.getText());
        target.setColor(source.getColor());

        return target;
    }
}
