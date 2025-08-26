package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @Column(name = "taskId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "taskCode")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private String priority;

    @Column(name = "fromDate")
    private Timestamp fromDate;

    @Column(name = "dueDate")
    private Timestamp dueDate;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    @Column(name = "updatedAt")
    private Timestamp updatedAt;

    @Column(name = "number")
    private int number;

    //Relationship
}
