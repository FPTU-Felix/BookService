package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntityOld {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "cayegory_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    @JsonManagedReference(value = "category-bookCategory")
    private List<BookCategory> bookCategories;
}
