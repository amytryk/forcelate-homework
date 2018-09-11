package com.homework.simplerestapi.service.imp;

import com.homework.simplerestapi.dao.UserRepository;
import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;
import com.homework.simplerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllWhereAgeMoreThan(int age) {
        return userRepository.findAllWhereAgeMoreThan(age);
    }

    @Override
    public List<String> findUniqueNamesWhereArticlesNumberMoreThan(int articlesNumber) {

        return userRepository.findUniqueNamesWhereArticlesNumberMoreThan(articlesNumber);
    }

    @Override
    public List<User> findAllByArticleColor(Color color) {

        return userRepository.findAllByArticleColor(color);
    }
}