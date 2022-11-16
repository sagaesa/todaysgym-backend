package com.sagaesa.record.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordFindOneDto {
    private Date date;

    private String content;
}
