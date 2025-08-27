package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate extends BaseEntityOld {
    @Id
    @Column(name = "rate_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "score")
    private int score;

    @ManyToOne
    @JoinColumn( name = "reader_id")
    @JsonBackReference(value = "reader-rates")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-rates")
    private Book book;
}
