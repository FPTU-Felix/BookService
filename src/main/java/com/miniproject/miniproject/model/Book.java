package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    private String id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "cover_image")
    private String coverImg;

    @Column(name = "price")
    private Double price;

    @Column(name = "publish_date")
    private String publishDate;

    // Relationship
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-favorites")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-bookOwnerShip")
    private List<BookOwnership> bookOwnershipList;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-rates")
    private List<Rate> rate;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-bookCategory")
    private List<BookCategory> bookCategories;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-posts")
    private List<Post> posts;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-chapters")
    private List<Chapter> chapters;

    @ManyToOne
    @JoinColumn(name = "published_by")
    @JsonBackReference(value = "book-publishers")
    private Publisher publisher;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
