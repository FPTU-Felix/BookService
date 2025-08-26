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
@Table(name = "milestone")
public class Milestone {
    @Id
    @Column(name = "milestoneId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "milestoneName")
    private String name;

    @Column(name = "startDate")
    private Timestamp startedDate;

    @Column(name = "endDate")
    private Timestamp endDate;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonBackReference(value = "project-milestones")
    private Project project;

    @OneToMany(mappedBy = "milestone")
    @JsonManagedReference(value = "milestone-task")
    private List<Task> tasks;

}
