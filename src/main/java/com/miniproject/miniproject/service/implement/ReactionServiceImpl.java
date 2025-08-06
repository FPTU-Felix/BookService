package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.CommentRequest;
import com.miniproject.miniproject.dto.Request.ReactionRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.Social.ReactionResponse;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Comments;
import com.miniproject.miniproject.model.Post;
import com.miniproject.miniproject.model.Reaction;
import com.miniproject.miniproject.model.User;
import com.miniproject.miniproject.repository.CommentRepository;
import com.miniproject.miniproject.repository.PostRepository;
import com.miniproject.miniproject.repository.ReactionRepository;
import com.miniproject.miniproject.repository.UserRepository;
import com.miniproject.miniproject.service.ReactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReactionServiceImpl implements ReactionService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ReactionRepository reactionRepository;
    private final PostRepository postRepository;

    @Autowired
    public ReactionServiceImpl(UserRepository userRepository, CommentRepository commentRepository, ReactionRepository reactionRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.reactionRepository = reactionRepository;
        this.postRepository = postRepository;
    }

    @Override
    public ApiResponse<List<ReactionResponse>> getAllReactions() {
        List<ReactionResponse> reactionResponses = reactionRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), reactionResponses, null);
    }

    @Override
    public List<ReactionResponse> getReactionForPost(String post_id) {
        List<Reaction> list = reactionRepository.findReactionByPostId(post_id);
        if (!list.isEmpty()) {
            return list.stream().map(this::mapToResponse)
                    .collect(Collectors.toList());
        } else throw new ResourceNotFoundException("Reaction not Found!");
    }

    @Override
    public ReactionResponse reactionComment(String commentId, String userId, ReactionRequest request) {
        Comments c = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comments not found!"));
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        Reaction newReaction = new Reaction();
        newReaction.setType(request.getType());
        newReaction.setComments(c);
        newReaction.setUser(u);
        Reaction savedReaction = reactionRepository.save(newReaction);
        return mapToResponse(savedReaction);
    }

    @Override
    public ReactionResponse reactionPost(String postId, String userId, ReactionRequest request) {
        Post p = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found!"));
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found!"));
        Optional<Reaction> existingReaction = reactionRepository.findByPostAndUser(p, u);
        Reaction reactionToSave = new Reaction();
        if (existingReaction.isPresent()) {
            // 2. Nếu đã tồn tại, cập nhật lại type
            reactionToSave = existingReaction.get();
            reactionToSave.setType(request.getType()); // Cập nhật loại cảm xúc
        } else {
            reactionToSave = new Reaction();
            reactionToSave.setType(request.getType());
            reactionToSave.setPost(p);
            reactionToSave.setUser(u);
        }
        Reaction savedReaction = reactionRepository.save(reactionToSave);
        return mapToResponse(savedReaction);
    }

    private ReactionResponse mapToResponse(Reaction reaction) {
        ReactionResponse b = new ReactionResponse();
        b.setType(reaction.getType());
        b.setCreated_at(reaction.getCreatedAt());
        b.setUpdated_at(reaction.getUpdatedAt());
        return b;
    }

    //maping entity
    private Comments mapToEntity(CommentRequest request) {
        Comments b = new Comments();
        b.setContent(request.getContent());
        return b;
    }

}
