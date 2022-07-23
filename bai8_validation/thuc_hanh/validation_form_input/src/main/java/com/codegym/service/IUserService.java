package com.codegym.service;

import com.codegym.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);
}
