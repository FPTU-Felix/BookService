package com.miniproject.miniproject.model;

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

}
