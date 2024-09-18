package com.photoleague.service.impl;

import com.photoleague.entity.Comment;
import com.photoleague.entity.dto.CommentDTO;
import com.photoleague.repository.UserRepository;
import com.photoleague.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;

    @Override
    public void save(CommentDTO commentDTO) {
        Comment comment = commentMapper.fromCommentDTOToComment(commentDTO);
        userRepository.save(comment);
    }

    @Override
    public List<CommentDTO> findAll() {
        return userRepository.findAll().stream()
                .map(commentMapper::fromCommentToCommentDTO)
                .toList();
    }

    @Override
    public CommentDTO findById(Long id) {
        return commentMapper.fromCommentToCommentDTO(userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Comment not found with id " + id)));
    }
}