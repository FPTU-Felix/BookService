package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EventParticipant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvenParticipants {
    @Id
    @Column(name = "eventParticipantId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-eventParticipant")
    private User user;

    @ManyToOne
    @JoinColumn(name = "eventId")
    @JsonBackReference(value = "event-evenParticipants")
    private Event event;

}
