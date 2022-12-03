package com.sagaesa.post;

import com.sagaesa.post.dto.PostCreateDto;
import com.sagaesa.post.dto.PostFindDto;
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
@RequestMapping("/posts")
public class PostController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PostService postService;

    @PostMapping
    public ResponseEntity recordPost(@RequestBody Map<String, String> recordRequest) {
        PostCreateDto postCreateDto = PostCreateDto.builder()
                .userId(Long.valueOf((recordRequest.get("userId"))))
                .categoryId(Long.valueOf(recordRequest.get("categoryId")))
                .date(Date.valueOf(recordRequest.get("date")))
                .title(recordRequest.get("title"))
                .content(recordRequest.get("content"))
                .build();

        postService.recordPost(postCreateDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("lists")
    public ResponseEntity<List<PostFindDto>> recordFineAll(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(postService.findAll(userId), HttpStatus.OK);
    }


}
