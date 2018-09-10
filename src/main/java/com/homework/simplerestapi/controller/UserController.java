package com.homework.simplerestapi.controller;

import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/search/age/{age}")
    public List<UserData> searchByAge(@PathVariable int age){

        return userFacade.searchByAge(age);
    }

    @GetMapping("/search/article")
    public List<UserData> searchByArticles(){

        return userFacade.searchByArticle();
    }

}
