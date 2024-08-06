package com.photoleague.mapper;

import com.photoleague.entity.Comment;
import com.photoleague.entity.dto.*;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CommentMapper {

    @Mapping(target = "message", source = "message")
    CommentDTO fromCommentToCommentDTO(Comment comment);

    @Mapping(target = "message", source = "message")
    Comment fromCommentDTOToComment(CommentDTO commentDTO);
}