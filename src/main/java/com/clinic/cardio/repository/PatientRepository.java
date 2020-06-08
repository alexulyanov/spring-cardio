package com.clinic.cardio.repository;

import com.clinic.cardio.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByLastName(@Param("lastName") String lastName);
    List<Patient> findByOhip(@Param("ohip") String ohip);
    Optional<Patient> findById(@Param("id") Long id);

}
