package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskAssignee    {
    @Id
    @Column(name = "taskAssigneeId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship

}
