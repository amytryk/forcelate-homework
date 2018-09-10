package com.homework.simplerestapi.controller;

import com.homework.simplerestapi.data.ArticleData;
import com.homework.simplerestapi.facade.ArticleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleFacade articleFacade;

    @PutMapping("/save")
    public ArticleData save(@RequestBody ArticleData articleData) {
        return articleFacade.save(articleData);
    }

    @GetMapping("/{id}")
    public ArticleData get(@PathVariable Long id) {
        return articleFacade.getById(id);
    }
}
