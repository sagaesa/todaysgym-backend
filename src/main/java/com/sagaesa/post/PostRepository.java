package com.sagaesa.post;

import com.sagaesa.title.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Title, Long> {
}
