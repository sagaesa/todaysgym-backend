package com.sagaesa.user_title;

import com.sagaesa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTitleRepository  extends JpaRepository<UserTitle, User> {

    List<UserTitle> findAllByUserId(User userId);
}
