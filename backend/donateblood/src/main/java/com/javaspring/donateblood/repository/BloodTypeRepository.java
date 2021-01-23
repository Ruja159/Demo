package com.javaspring.donateblood.repository;

import com.javaspring.donateblood.model.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodTypeRepository extends JpaRepository<BloodType, Long> {
}
