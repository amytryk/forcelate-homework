package com.homework.simplerestapi.dao;

import com.homework.simplerestapi.entity.Color;
import com.homework.simplerestapi.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.age > :age")
    List<User> findAllWhereAgeMoreThan(@Param("age") int age);

    @Query("select distinct u.name from User u where id in (select user.id from Article a group by user.id having count(a.user.id) > :articlesNumber)")
    List<String> findUniqueNamesWhereArticlesNumberMoreThan(@Param("articlesNumber") long articlesNumber);

    @Query("select u from User u inner join fetch u.articles as a where a.color = :color")
    List<User> findAllByArticleColor(@Param("color") Color color);

}
