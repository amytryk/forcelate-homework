package com.homework.simplerestapi.facade.imp;

import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;
import com.homework.simplerestapi.facade.UserFacade;
import com.homework.simplerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private Converter<UserData, User> dtoToUserConverter;

    @Autowired
    private Converter<User, UserData> userToDtoConverter;

    @Override
    public UserData save(UserData userData) {
        User savedUser = userService.save(dtoToUserConverter.convert(userData));

        return userToDtoConverter.convert(savedUser);
    }

    @Override
    public List<UserData> searchByAge(int age) {
        List<User> result = userService.findAllWhereAgeMoreThan(age);
        List<UserData> userDataList = result.stream()
                .map(user -> userToDtoConverter.convert(user))
                .collect(Collectors.toList());

        return userDataList;
    }

    @Override
    public List<String> searchNamesByArticlesNumber(long articlesNumber) {

        return userService.findUniqueNamesWhereArticlesNumberMoreThan(articlesNumber);
    }

    @Override
    public List<UserData> searchByArticleColor(Color color) {
        List<User> result = userService.findAllByArticleColor(color);
        List<UserData> userData = result.stream().map(user -> userToDtoConverter.convert(user))
                .collect(Collectors.toList());

        return userData;
    }


}
