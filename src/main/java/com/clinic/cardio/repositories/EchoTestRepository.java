package com.clinic.cardio.repositories;

import com.clinic.cardio.models.EchoTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EchoTestRepository extends CrudRepository<EchoTest, Long> {
    @Transactional(readOnly = true)
    Optional<EchoTest> findById(Long id);

}
