package com.miniproject.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.model.WorkFlowTransition;

public interface WorkflowTransitionRepository extends JpaRepository<WorkFlowTransition, String> {
}
