package com.sagaesa.post;

import com.sagaesa.post.dto.PostCreateDto;
import com.sagaesa.post.dto.PostFindDto;
import com.sagaesa.user.User;
import com.sagaesa.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void recordPost(PostCreateDto postCreateDto) {
        Post post = new Post();

        Optional<User> user = userRepository.findById(postCreateDto.getUserId());
        post.save(postCreateDto.getDate(), postCreateDto.getTitle(), postCreateDto.getContent(),
                user.get(), user.get().getCategoryId());

        postRepository.save(post);
    }

    public List<PostFindDto> findAll(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Post> posts = postRepository.findAllByCategoryId(user.get().getCategoryId());
        List<PostFindDto> postFindDtos = new ArrayList<>();

        for (Post post : posts) {
            PostFindDto postFindDto = PostFindDto.builder()
                    .date(post.getDate())
                    .title(post.getTitle())
                    .build();

            postFindDtos.add(postFindDto);
        }

        return postFindDtos;
    }
}
