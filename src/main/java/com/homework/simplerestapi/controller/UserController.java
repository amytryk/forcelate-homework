package com.homework.simplerestapi.controller;

import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PutMapping("/save")
    public UserData save(@RequestBody UserData userData) {

        return userFacade.save(userData);
    }

    @GetMapping("/search/byAge")
    public List<UserData> searchByAge(@RequestParam("userAgeIsMoreThan") int age) {

        return userFacade.searchByAge(age);
    }

    @GetMapping("/search/names")
    public List<String> searchNamesByArticlesNumber() {

        return userFacade.searchNamesByArticlesNumber(3L);
    }

    @GetMapping("/search/byArticleColor")
    public List<UserData> searchByArticleColor(@RequestParam("articleColor") Color color) {

        return userFacade.searchByArticleColor(color);
    }
}
