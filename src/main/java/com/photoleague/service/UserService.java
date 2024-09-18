package com.photoleague.service;
import com.photoleague.entity.User;
import com.photoleague.entity.dto.CommentDTO;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> findAll();
    User findById(Long id);
}