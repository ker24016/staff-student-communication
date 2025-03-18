package com.byui.studentstaffcommunication.repository;

import com.byui.studentstaffcommunication.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByAuthorId(String authorId, Pageable pageable);
    List<Post> findByParentId(String parentId, Pageable pageable);
    List<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
