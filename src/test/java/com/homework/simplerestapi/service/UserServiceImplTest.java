package com.homework.simplerestapi.service;

import com.homework.simplerestapi.dao.UserRepository;
import com.homework.simplerestapi.entity.User;
import com.homework.simplerestapi.service.imp.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserService userService;
    private UserRepository userRepositoryMock;

    @Before
    public void setUp() {
        userRepositoryMock = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepositoryMock);

        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setAge(26);

        when(userRepositoryMock.save(any(User.class))).thenReturn(user);
        when(userRepositoryMock.findAllWhereAgeMoreThan(25)).thenReturn(Collections.singletonList(user));
    }


    @Test
    public void save() {
        User savedUser = userService.save(mock(User.class));

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getName()).isEqualTo("test");
        assertThat(savedUser.getAge()).isEqualTo(26);
    }

    @Test
    public void findAllWhereAgeMoreThan(){
        List<User> users = userService.findAllWhereAgeMoreThan(25);

        assertThat(users).isNotNull();
        assertThat(users).hasSize(1);
    }
}
