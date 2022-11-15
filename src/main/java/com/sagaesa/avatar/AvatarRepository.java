package com.sagaesa.avatar;

import com.sagaesa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<User, Long> {
}
