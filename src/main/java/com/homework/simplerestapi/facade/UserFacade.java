package com.homework.simplerestapi.facade;

import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.entity.Color;

import java.util.List;

public interface UserFacade {

    UserData save(UserData userData);
    List<UserData> searchByAge(int age);
    List<String> searchNamesByArticlesNumber(long articlesNumber);
    List<UserData> searchByArticleColor(Color color);


}
