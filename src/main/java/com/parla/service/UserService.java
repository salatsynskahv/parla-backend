package com.parla.service;

import com.parla.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User findById(Long id);
    User findByUsername(String username);
    void save(User user);
}
