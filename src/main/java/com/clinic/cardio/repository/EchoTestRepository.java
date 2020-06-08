package com.clinic.cardio.repository;

import com.clinic.cardio.model.EchoTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EchoTestRepository extends JpaRepository<EchoTest, Long> {
    List<EchoTest> findEchoTestsByPatientId(@Param("id") Long id);
    Optional<EchoTest> findById(@Param("id") Long id);

}
