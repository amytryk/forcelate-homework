package com.homework.simplerestapi.service;

import com.homework.simplerestapi.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAllWhereAgeMoreThan(int age);

}
