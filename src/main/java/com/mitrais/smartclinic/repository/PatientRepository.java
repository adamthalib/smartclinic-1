package com.mitrais.smartclinic.repository;

import com.mitrais.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT MAX(p.id) FROM Patient p " +
            "ORDER BY p.id " +
            "DESC")
    Integer lastID();
}
