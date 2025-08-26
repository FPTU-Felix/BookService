package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "Event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @Column(name = "eventId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "startTime")
    private Timestamp startTime;

    @Column(name = "endTime")
    private Timestamp endTime;

    @Column(name = "meetingLink")
    private String link;

    //relationship
}
