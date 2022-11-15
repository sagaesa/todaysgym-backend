package com.sagaesa.comment;

import com.sagaesa.title.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Title, Long> {
}
