package com.sagaesa.record.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {
    private int recordId;

    private Long userId;

    private Date date;

    private String content;
}
