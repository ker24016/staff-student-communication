package com.byui.studentstaffcommunication.repository;

import com.byui.studentstaffcommunication.model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByAuthorId(Long authorId, Pageable pageable);

    List<Post> findAllByAuthorIdContainingIgnoreCaseOrTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String authorId, String title, String content, Pageable pageable);

    List<Post> findAllByParent(Post parent, Pageable pageable);

    List<Post> findAllByParentId(Long parentId, Pageable pageable);

    List<Post> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);
}
