package com.homework.simplerestapi.facade;

import com.homework.simplerestapi.data.UserData;

import java.util.List;

public interface UserFacade {

    UserData save(UserData userData);
    List<UserData> searchByAge(int age);


}
