package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
