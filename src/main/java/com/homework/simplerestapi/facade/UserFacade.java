package com.homework.simplerestapi.facade;

import com.homework.simplerestapi.data.UserData;
import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;

import java.util.List;

public interface UserFacade {

    UserData save(UserData userData);
    List<UserData> searchByAge(int age);
    List<String> searchUserNamesByArticle();
    List<UserData> searchUserByArticleColor(Color color);


}
