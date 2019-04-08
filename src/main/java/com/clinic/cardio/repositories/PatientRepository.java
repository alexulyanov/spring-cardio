package com.clinic.cardio.repositories;

import com.clinic.cardio.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    List<Patient> findAll();
    List<Patient> findByLastName(@Param("lastName") String lastName);
    Optional<Patient> findById(@Param("id") Long id);

}
