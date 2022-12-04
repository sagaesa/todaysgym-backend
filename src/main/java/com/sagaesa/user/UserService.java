package com.sagaesa.user;

import com.sagaesa.avatar.Avatar;
import com.sagaesa.avatar.AvatarRepository;
import com.sagaesa.avatar.AvatarService;
import com.sagaesa.category.Category;
import com.sagaesa.category.CategoryRepository;
import com.sagaesa.post.Post;
import com.sagaesa.user.dto.PostLoginReq;
import com.sagaesa.user.dto.PostSignupReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AvatarRepository avatarRepository;
    private final AvatarService avatarService;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public Long create(PostSignupReq postSignupReq) {

        Category category = categoryRepository.getByCategoryId(postSignupReq.getCategoryId()).orElse(null);

        User user = User.builder()
                .name(postSignupReq.getName())
                .password(postSignupReq.getPassword())
                .nickname(postSignupReq.getNickname())
                .avatarId(null)
                .categoryId(category)
                .build();

        save(user);

        return user.getId();
    }





}
