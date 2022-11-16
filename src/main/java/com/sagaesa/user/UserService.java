package com.sagaesa.user;

import com.sagaesa.avatar.Avatar;
import com.sagaesa.category.Category;
import com.sagaesa.category.CategoryRepository;
import com.sagaesa.user.dto.PostSignupReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    public Long createUser(PostSignupReq postSignupReq) {

        Category category = categoryRepository.getByCategoryId(postSignupReq.getCategoryId()).orElse(null);
        //Avatar avatar

        User user = User.builder()
                .name(postSignupReq.getName())
                .password(postSignupReq.getPassword())
                .nickname(postSignupReq.getNickname())
                //.avatarId(avatar)
                .categoryId(category)
                .build();

        save(user);

        return user.getId();
    }
}
