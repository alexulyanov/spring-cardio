package com.clinic.cardio.repository;

import com.clinic.cardio.model.EchoTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EchoTestRepository extends JpaRepository<EchoTest, Long> {
    @Transactional(readOnly = true)
    Optional<EchoTest> findById(Long id);
    List<EchoTest> findEchoTestsByPatientId(Long id);

}
