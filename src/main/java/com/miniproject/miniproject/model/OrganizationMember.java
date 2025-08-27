package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrganizationMember")
public class OrganizationMember {
    @Id
    @Column(name = "organizationMemberId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
//Relationship
    @ManyToOne
    @JoinColumn(name = "orgId")
    @JsonBackReference(value = "organization-organizationMember")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-organizationMember")
    private User user;
}
