package com.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

}