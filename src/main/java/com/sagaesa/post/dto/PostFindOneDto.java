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
public class PostFindOneDto {
    private Long userId;

    private Date date;

    private String title;

    private String content;
}
