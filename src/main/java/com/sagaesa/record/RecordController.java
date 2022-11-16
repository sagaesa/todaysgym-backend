package com.sagaesa.record;

import com.sagaesa.record.dto.RecordDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RecordService recordService;

    @PostMapping
    public ResponseEntity recordCreate(@RequestBody Map<String, String> recordRequest) {
        RecordDto recordDto = RecordDto.builder()
                .userId(Long.valueOf((recordRequest.get("userId"))))
                .date(Date.valueOf(recordRequest.get("date")))
                .content(recordRequest.get("content"))
                .build();

        recordService.recordCreate(recordDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
