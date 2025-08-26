package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-taskComment")
    private User user;

    @ManyToOne
    @JoinColumn(name = "taskId")
    @JsonBackReference(value = "task-taskComment")
    private Task task;
}
