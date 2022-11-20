package com.sagaesa.title;

import com.sagaesa.title.dto.TitleFindDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/titles")
public class TitleController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TitleService titleService;

    @GetMapping
    public ResponseEntity<List<TitleFindDto>> titleFindAll(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(titleService.findAll(userId), HttpStatus.OK);
    }

}
