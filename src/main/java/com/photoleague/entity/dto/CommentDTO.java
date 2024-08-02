package com.photoleague.entity.dto;

import jakarta.validation.constraints.NotEmpty;

public record CommentDTO(Long id,
                         @NotEmpty(message = "Comment should have a comment") String message) {
}