package com.miniproject.miniproject.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projectMember")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {
    @Id
    @Column(name = "projectMemberId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship
}
