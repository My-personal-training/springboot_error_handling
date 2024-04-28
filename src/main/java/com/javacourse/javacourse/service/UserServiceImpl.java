package com.javacourse.javacourse.service;

import com.javacourse.javacourse.models.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {

    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
