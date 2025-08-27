package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments extends BaseEntityOld {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "content")
    private String content;

    //Relationships with User and Post can be added here if needed
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference(value = "post-comments")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-comments")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    @JsonBackReference(value = "chapter-comments")
    private Chapter chapter;

    @OneToMany(mappedBy = "comments")
    @JsonManagedReference(value = "comment-reaction")
    private List<Reaction> reactions;

    @ManyToOne
    @JoinColumn(name = "replied_to_id") // Foreign key column
    @JsonBackReference(value = "repliedTo")
    private Comments repliedTo;

    @OneToMany(mappedBy = "repliedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "repliedTo")
    private List<Comments> replies;

    @Formula("(SELECT count(*) FROM comment rep WHERE rep.replied_to_id = comment_id)")
    private int replyCount;

    // Đếm số lượng 'LIKE'
    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'LIKE')")
    private int likeCount;

    // Đếm số lượng 'LOVE'
    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'LOVE')")
    private int loveCount;

    // Đếm số lượng 'HAHA'
    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'HAHA')")
    private int hahaCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'SAD')")
    private int sadCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'WOW')")
    private int wowCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.comment_id = comment_id AND r.type = 'ANGRY')")
    private int angryCount;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }//
}
