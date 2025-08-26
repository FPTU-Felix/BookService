package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

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
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-task")
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference(value = "project-task")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "milestoneId")
    @JsonBackReference(value = "milestoneId-task")
    private Task task;

    @OneToMany(mappedBy = "task")
    @JsonManagedReference(value = "task-taskAssignee")
    private List<TaskAssignee> taskAssignees;

    @OneToMany(mappedBy = "task")
    @JsonManagedReference(value = "task-taskComment")
    private List<TaskComment> taskComments;

    @OneToMany(mappedBy = "task")
    @JsonManagedReference(value = "task-taskHistory")
    private List<TaskHistory> taskHistories;

    @OneToMany(mappedBy = "task")
    @JsonManagedReference(value = "task-attachment")
    private List<Attachment> attachments;
}
