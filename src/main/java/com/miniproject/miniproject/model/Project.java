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
    @ManyToOne
    @JoinColumn(name = "orgId")
    @JsonBackReference(value = "organization-project")
    private Organization organization;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference(value = "project-projectMember")
    private List<ProjectMember> projectMembers;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference(value = "project-milestones")
    private List<Milestone> milestones;

    @OneToOne(mappedBy = "project")
    @JsonManagedReference(value = "project-workflow")
    private List<Workflow> workflows;

    @OneToMany(mappedBy = "project")
    @JsonManagedReference(value = "project-task")
    private List<Task> tasks;
}
