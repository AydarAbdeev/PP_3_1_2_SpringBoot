package com.example.PP_3_1_2_SpringBoot.services;

import com.example.PP_3_1_2_SpringBoot.models.User;
import com.example.PP_3_1_2_SpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User userUpdate) {
        userUpdate.setId(id);
        userRepository.save(userUpdate);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
