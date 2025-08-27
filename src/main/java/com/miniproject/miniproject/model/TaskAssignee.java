package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "taskAssignee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssignee    {
    @Id
    @Column(name = "taskAssigneeId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-taskAssignee")
    private User user;

    @ManyToOne
    @JoinColumn(name = "taskId")
    @JsonBackReference(value = "task-taskAssignee")
    private Task task;
}
