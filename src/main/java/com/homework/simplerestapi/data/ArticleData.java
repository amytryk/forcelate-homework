package com.homework.simplerestapi.data;

import com.homework.simplerestapi.entity.Color;

public class ArticleData {
    private Long id;
    private String text;
    private Color color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ArticleData{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", color=" + color +
                '}';
    }
}
