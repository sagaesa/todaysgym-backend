package com.sagaesa.avatar;

import com.sagaesa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends JpaRepository<User, Long> {
}
