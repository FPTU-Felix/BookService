package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    @Query("SELECT DISTINCT p FROM Project p LEFT JOIN p.projectMembers pm WHERE p.user.id = :userId OR pm.user.id = :userId")
    List<Project> findAllRelatedProjectsByUserId(@Param("userId") String userId);
}
