package com.miniproject.miniproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.model.Status;

public interface StatusRepository extends JpaRepository<Status, String> {

}
