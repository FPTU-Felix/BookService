package com.miniproject.miniproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, String> {
    @Override
    @EntityGraph(attributePaths = {"postImages", "user"})
        // Tải kèm cả danh sách images và đối tượng user
    Page<Post> findAll(Pageable pageable);

    @Override
    @EntityGraph(attributePaths = {"postImages", "user"})
    Optional<Post> findById(String id);
    // Custom query methods can be defined here if needed
    // For example, to find posts by title:
    // List<Post> findByTitleContaining(String title);
    // Or to find posts by user:
    // List<Post> findByUserId(Integer userId);
}
