package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projectMember")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {
    @Id
    @Column(name = "projectMemberId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-projectMember")
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference(value = "project-projectMember")
    private Project project;
}
