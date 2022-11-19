package com.sagaesa.category;

import com.sagaesa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<User, Long> {

    Optional<Category> getByCategoryId(Long categoryId);
}
