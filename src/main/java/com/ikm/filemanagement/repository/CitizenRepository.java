package com.ikm.filemanagement.repository;

import com.ikm.filemanagement.model.CitizenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenData, Integer> {
}
