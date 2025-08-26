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
@Table(name = "Milestone")
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

}
