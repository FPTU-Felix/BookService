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
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @Column(name = "statusId")
    private String id;

    @Column(name = "statusName")
    private String statusName;

    @Column(name = "color")
    private String color;

    @Column(name = "position")
    private String position;

    @Column(name = "data")
    private String data;

    @Column(name = "isStart")
    private boolean isStart;

    @Column(name = "isEnd")
    private boolean isEnd;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "workFlowId")
    @JsonBackReference(value = "workFlow-status")
    private Workflow workFlow;

    @OneToMany(mappedBy = "status")
    @JsonManagedReference(value = "status-WorkFlowTransition")
    private List<WorkFlowTransition> workFlowTransitions;
}
