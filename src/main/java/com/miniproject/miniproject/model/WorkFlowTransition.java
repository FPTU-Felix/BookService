package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "WorkFlowTrasition")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkFlowTransition {
    @Id
    @Column(name = "transitionId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "source")
    private String source;

    @Column(name = "target")
    private String target;

    @Column(name = "label")
    private String label;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "statusId")
    @JsonBackReference(value = "status-WorkFlowTransition")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "workFlowId")
    @JsonBackReference(value = "workFlow-WorkFlowTransition")
    private Workflow workflow;

}
