package com.sagaesa.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    private Long userId;

    private Long categoryId;

    private Date date;

    private String title;

    private String content;
}
