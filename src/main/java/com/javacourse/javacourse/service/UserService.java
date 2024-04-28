package com.javacourse.javacourse.service;

import com.javacourse.javacourse.models.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);

}
