package com.miniproject.miniproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.miniproject.model.Project;
import com.miniproject.miniproject.model.Workflow;

@Repository
public interface WorkflowRepository extends JpaRepository<Workflow, String> {
    Optional<Workflow> findByProject_Id(String projectId);
}
