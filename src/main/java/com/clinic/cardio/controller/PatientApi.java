package com.clinic.cardio.controller;

import com.clinic.cardio.exception.ResourceNotFoundException;
import com.clinic.cardio.model.EchoTest;
import com.clinic.cardio.model.Patient;
import com.clinic.cardio.repository.EchoTestRepository;
import com.clinic.cardio.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientApi {

    private final PatientRepository patientRepository;
    private final EchoTestRepository echoTestRepository;

    public PatientApi(PatientRepository patientRepository, EchoTestRepository echoTestRepository) {
        this.patientRepository = patientRepository;
        this.echoTestRepository = echoTestRepository;
    }

    @GetMapping(path="/patients")
    public ResponseEntity<?> getAllPatients(Pageable pageable){
        Page result = patientRepository.findAll(pageable);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/patients")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) throws URISyntaxException {
        Patient result = patientRepository.save(patient);
        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
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
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path="/patients/{id}/echotests")
    public ResponseEntity<?> getEchoTestsByPatient(@PathVariable Long id){
        List<EchoTest> result = echoTestRepository.findEchoTestsByPatientId(id);


        return ResponseEntity.ok(result);
    }


}
