package com.photoleague.service;
import com.photoleague.entity.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    void save(CommentDTO commentDTO);
    List<CommentDTO> findAll();
    CommentDTO findById(Long id);
}