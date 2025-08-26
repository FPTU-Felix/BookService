package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "TaskHistory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskHistory {
    @Id
    @Column(name = "historyId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "changeValue")
    private String changeValue;

    @Column(name = "changeAt")
    private Timestamp changeAt;

    //RelationShip
}
