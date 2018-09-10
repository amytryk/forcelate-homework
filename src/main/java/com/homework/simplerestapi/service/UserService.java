package com.homework.simplerestapi.service;

import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAllWhereAgeMoreThan(int age);
    List<String> findUniqueNamesWhereNumberOfArticlesMoreThanThree();
    List<User> findAllByArticleColor(Color color);

}
