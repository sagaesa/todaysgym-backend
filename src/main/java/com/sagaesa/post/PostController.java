package com.sagaesa.post;

import com.sagaesa.post.dto.PostCreateDto;
import com.sagaesa.post.dto.PostFindAllDto;
import com.sagaesa.post.dto.PostFindOneDto;
import com.sagaesa.post.dto.PostUpdateDto;
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
    public ResponseEntity postCreate(@RequestBody Map<String, String> recordRequest) {
        PostCreateDto postCreateDto = PostCreateDto.builder()
                .userId(Long.valueOf((recordRequest.get("userId"))))
                .categoryId(Long.valueOf(recordRequest.get("categoryId")))
                .date(Date.valueOf(recordRequest.get("date")))
                .title(recordRequest.get("title"))
                .content(recordRequest.get("content"))
                .build();

        postService.postCreate(postCreateDto);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<List<PostFindAllDto>> postFineAll(@RequestParam("userId") Long userId) {
        return new ResponseEntity<>(postService.findAll(userId), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<PostFindOneDto> postFindOne(@RequestParam("postId") Long postId) {
        return new ResponseEntity<>(postService.findOne(postId), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<PostFindOneDto> postUpdate(@RequestBody Map<String, String> postRequest) {
        PostUpdateDto postUpdateDto = PostUpdateDto.builder()
                .postId(Long.valueOf(postRequest.get("postId")))
                .date(Date.valueOf(postRequest.get("date")))
                .title(postRequest.get("title"))
                .content(postRequest.get("content"))
                .build();

        return new ResponseEntity<>(postService.update(postUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity postDelete(@RequestParam("postId") Long postId) {
        postService.delete(postId);

        return new ResponseEntity(HttpStatus.OK);
    }
}
