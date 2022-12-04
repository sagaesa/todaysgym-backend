package com.sagaesa.post;

import com.sagaesa.post.dto.PostCreateDto;
import com.sagaesa.post.dto.PostFindAllDto;
import com.sagaesa.post.dto.PostFindOneDto;
import com.sagaesa.post.dto.PostUpdateDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void postCreate(PostCreateDto postCreateDto) {
        Post post = new Post();

        Optional<User> user = userRepository.findById(postCreateDto.getUserId());
        post.save(postCreateDto.getDate(), postCreateDto.getTitle(), postCreateDto.getContent(),
                user.get(), user.get().getCategoryId());

        postRepository.save(post);
    }

    public List<PostFindAllDto> findAll(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Post> posts = postRepository.findAllByCategoryId(user.get().getCategoryId());
        List<PostFindAllDto> postFindAllDtos = new ArrayList<>();

        for (Post post : posts) {
            PostFindAllDto postFindAllDto = PostFindAllDto.builder()
                    .date(post.getDate())
                    .title(post.getTitle())
                    .build();

            postFindAllDtos.add(postFindAllDto);
        }

        return postFindAllDtos;
    }

    public PostFindOneDto findOne(Long postId) {
        Optional<Post> post = postRepository.findById(postId);


        return PostFindOneDto.builder()
                .userId(post.get().getUserId().getId())
                .date(post.get().getDate())
                .title(post.get().getTitle())
                .content(post.get().getContent())
                .build();
    }

    public PostFindOneDto update(PostUpdateDto postUpdateDto) {
        Post post = postRepository.findById(postUpdateDto.getPostId()).orElseThrow();
        post.update(postUpdateDto.getDate(), postUpdateDto.getTitle(), postUpdateDto.getContent());

        return PostFindOneDto.builder()
                .userId(post.getUserId().getId())
                .date(post.getDate())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
