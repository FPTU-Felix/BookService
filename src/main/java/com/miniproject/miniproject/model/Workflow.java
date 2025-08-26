package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "workFlow")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workflow {
    @Id
    @Column(name = "workFlowId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "workFlowName")
    private String workFlowName;

    @Column(name = "description")
    private String description;

    //Relationship

    @OneToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference(value = "project-workflow")
    private Project project;

    @OneToMany(mappedBy = "workFlow")
    @JsonManagedReference(value = "workFlow-status")
    private List<Status> statuses;

    @OneToMany(mappedBy = "workFlow")
    @JsonManagedReference(value = "workFlow-WorkFlowTransition")
    private List<WorkFlowTransition> workFlowTransitions;
}
