package com.photoleague.controller;

import com.photoleague.entity.dto.CommentDTO;
import com.photoleague.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    private final UserService userService;

    @GetMapping
    public List<CommentDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Validated @RequestBody CommentDTO commentDTO) {
        userService.save(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}