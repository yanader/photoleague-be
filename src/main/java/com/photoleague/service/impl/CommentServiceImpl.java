package com.photoleague.service.impl;

import com.photoleague.mapper.CommentMapper;
import com.photoleague.entity.Comment;
import com.photoleague.entity.dto.CommentDTO;
import com.photoleague.repository.CommentRepository;
import com.photoleague.service.CommentService;
import com.photoleague.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = commentMapper.fromCommentDTOToComment(commentDTO);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentRepository.findAll().stream()
                .map(commentMapper::fromCommentToCommentDTO)
                .toList();
    }

    @Override
    public CommentDTO findById(Long id) {
        return commentMapper.fromCommentToCommentDTO(commentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id " + id)));
    }
}