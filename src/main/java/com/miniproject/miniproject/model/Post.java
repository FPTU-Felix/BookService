package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity{

    @Id
    @Column(name = "post_id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-posts")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-posts")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    @JsonBackReference(value = "chapter-posts")
    private Chapter chapter;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "post-postImg")
    private List<PostImage> postImages;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "post-reaction")
    private List<Reaction> reactions;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "post-comments")
    private List<Comments> comments;

    // Hibernate sẽ tự động chạy câu lệnh SELECT count(*) này để lấy giá trị cho trường commentCount
    @Formula("(SELECT count(*) FROM comment c WHERE c.post_id = post_id)")
    private int commentCount;

    // Tương tự, tính tổng số reaction cho bài post này
    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id)")
    private int allReactionCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'LIKE')")
    private int likeCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'LOVE')")
    private int loveCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'HAHA')")
    private int hahaCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'SAD')")
    private int sadCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'WOW')")
    private int wowCount;

    @Formula("(SELECT count(*) FROM reaction r WHERE r.post_id = post_id AND r.type = 'ANGRY')")
    private int angryCount;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
