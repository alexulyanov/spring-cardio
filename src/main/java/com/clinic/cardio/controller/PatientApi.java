package com.clinic.cardio.controller;

import com.clinic.cardio.exception.ResourceNotFoundException;
import com.clinic.cardio.model.Patient;
import com.clinic.cardio.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientApi {

    private final PatientRepository patientRepository;

    public PatientApi(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping(path="/patients")
    public ResponseEntity<?> getAllPatients(Pageable pageable){
        Page result = patientRepository.findAll(pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) throws URISyntaxException {
        Patient result = patientRepository.save(patient);
        return ResponseEntity.created(new URI("/api/patients/" + result.getId()))
                .body(result);
    }

    @GetMapping(path="/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id){
        Optional<Patient> result = patientRepository.findById(id);
        return result.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResourceNotFoundException("Patient with id " + id + " not found"));
    }

    @PutMapping("/patients/{id}")
    ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient patient) {
        Patient result = patientRepository.save(patient);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
