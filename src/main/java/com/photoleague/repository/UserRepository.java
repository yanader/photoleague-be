package com.photoleague.repository;

import com.photoleague.entity.Comment;
import com.photoleague.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}