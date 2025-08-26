package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @Column(name = "projectId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "projectName")
    private String name;

    @Column(name = "projectCode")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "createdAt")
    private Timestamp createdAt;

    //Relationship
}
