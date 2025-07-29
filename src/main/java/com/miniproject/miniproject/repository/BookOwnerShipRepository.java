package com.miniproject.miniproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.model.BookOwnership;

public interface BookOwnerShipRepository extends JpaRepository<BookOwnership, String> {
}
