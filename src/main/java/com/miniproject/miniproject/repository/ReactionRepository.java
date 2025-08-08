package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Comments;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.Reaction;
import com.miniproject.miniproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, String> {
    @Query("SELECT r FROM Reaction r WHERE r.post.id = :postId")
    List<Reaction> findReactionByPostId(@Param("postId") String postId);

    Optional<Reaction> findByPost_IdAndUser_Id(String postId, String userId);

    Optional<Reaction> findByComments_IdAndUser_Id(String commentId, String userId);

    void deleteByPost_IdAndUserId(String postId, String userId);

    void deleteByComments_IdAndUserId(String commentId, String userId);

}
