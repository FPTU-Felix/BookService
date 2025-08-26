package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskComment {
    @Id
    @Column(name = "taskCommentId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "commentText")
    private String commentText;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    //RelationShip
}
