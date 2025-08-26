package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "organization")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    @Column(name = "orgId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "orgName")
    private String name;

    @Column(name = "createAt")
    private Timestamp createdAt;

    //Relationship
    @OneToMany(mappedBy = "organization")
    @JsonManagedReference(value = "organization-organizationMember")
    private List<OrganizationMember> organizationMemberList;
}
