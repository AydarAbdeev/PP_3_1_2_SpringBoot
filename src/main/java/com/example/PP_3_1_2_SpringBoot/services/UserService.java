package com.example.PP_3_1_2_SpringBoot.services;

import com.example.PP_3_1_2_SpringBoot.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(int id);
    void save(User user);
    void update(int id, User userUpdate);
    void delete(int id);
}
