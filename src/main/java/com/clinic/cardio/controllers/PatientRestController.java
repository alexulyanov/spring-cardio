package com.clinic.cardio.controllers;

import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientRestController {

    private final PatientRepository patientRepository;

    public PatientRestController(PatientRepository cardioService) {
        this.patientRepository = cardioService;
    }

    @GetMapping(path="/patients")
    public ResponseEntity<?> getAllEmployees(){
        List<Patient> result = patientRepository.findAll();
        return ResponseEntity.ok(result);
    }
}
