package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, String> {
    @Query("SELECT p.organization FROM Project p WHERE p.id = :projectId")
    Optional<Organization> findOrganizationByProjectId(@Param("projectId") String projectId);
}
