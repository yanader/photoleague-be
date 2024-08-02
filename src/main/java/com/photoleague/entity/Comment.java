package com.photoleague.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comment_table")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;
}