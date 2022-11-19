package com.sagaesa.user;

import com.sagaesa.avatar.Avatar;
import com.sagaesa.avatar.AvatarService;
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
    private final AvatarService avatarService;

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }


}
