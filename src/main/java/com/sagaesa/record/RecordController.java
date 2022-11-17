package com.sagaesa.record;

import com.sagaesa.record.dto.RecordCreateDto;
import com.sagaesa.record.dto.RecordFindDto;
import com.sagaesa.record.dto.RecordUpdateDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/records")
public class RecordController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final RecordService recordService;

    @PostMapping
    public ResponseEntity recordCreate(@RequestBody Map<String, String> recordRequest) {
        RecordCreateDto recordCreateDto = RecordCreateDto.builder()
                .userId(Long.valueOf((recordRequest.get("userId"))))
                .date(Date.valueOf(recordRequest.get("date")))
                .content(recordRequest.get("content"))
                .build();

        recordService.recordCreate(recordCreateDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<RecordFindDto> recordFindOne(@RequestParam("recordId") Long recordId) {
        return new ResponseEntity<>(recordService.findOne(recordId), HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<RecordFindDto>> recordFineAll(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(recordService.findAll(userId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<RecordFindDto> recordUpdate(@RequestBody Map<String, String> recordRequest) {
        RecordUpdateDto recordUpdateDto = RecordUpdateDto.builder()
                .recordId(Long.valueOf(recordRequest.get("recordId")))
                .date(Date.valueOf(recordRequest.get("date")))
                .content(recordRequest.get("content"))
                .build();

        return new ResponseEntity<>(recordService.update(recordUpdateDto), HttpStatus.OK);
    }
}
