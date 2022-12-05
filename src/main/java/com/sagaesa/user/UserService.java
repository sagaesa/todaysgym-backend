package com.sagaesa.user;

import com.sagaesa.avatar.Avatar;
import com.sagaesa.avatar.AvatarRepository;
import com.sagaesa.avatar.AvatarService;
import com.sagaesa.category.Category;
import com.sagaesa.category.CategoryRepository;
import com.sagaesa.post.Post;
import com.sagaesa.user.dto.GetUserProfileRes;
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


    public Long login(PostLoginReq postLoginReq) {
        User user = userRepository.getByName(postLoginReq.getName()).orElse(null);

        // 비밀번호가 같다면 userId return
        if(user.getPassword().equals(postLoginReq.getPassword())) {
            return user.getId();
        } else { // 비밀번호가 다르다면 -1 return
            return -1L;
        }
    }

    public GetUserProfileRes getProfile(Long userId) {
        User user = userRepository.findById(userId).get();

        return GetUserProfileRes.builder()
                .nickname(user.getNickname())
                .avatarId(user.getAvatarId().getId())
                .build();
    }

}
