package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "TaskHistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskHistory {
    @Id
    @Column(name = "historyId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "changeValue")
    private String changeValue;

    @Column(name = "changeAt")
    private Timestamp changeAt;

    //RelationShip
    @ManyToOne
    @JoinColumn(name = "taskId")
    @JsonBackReference(value = "task-taskHistory")
    private Task task;
}
