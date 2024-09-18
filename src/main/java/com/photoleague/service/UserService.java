package com.photoleague.service;
import com.photoleague.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
}