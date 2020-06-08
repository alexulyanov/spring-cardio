package com.clinic.cardio.controller;

import com.clinic.cardio.exception.ResourceNotFoundException;
import com.clinic.cardio.model.EchoTest;
import com.clinic.cardio.repository.EchoTestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients/{id}/")
public class EchoTestApi {

    private final EchoTestRepository echoTestRepository;

    public EchoTestApi(EchoTestRepository echoTestRepository) {
        this.echoTestRepository = echoTestRepository;
    }

    @GetMapping(path="/echotests")
    public ResponseEntity<?> getEchoTestsByPatient(@PathVariable Long id){
        List<EchoTest> result = echoTestRepository.findEchoTestsByPatientId(id);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/echotests")
    public ResponseEntity<EchoTest> createEchoTest(@Valid @RequestBody EchoTest echoTest) throws URISyntaxException {
        EchoTest result = echoTestRepository.save(echoTest);
        return ResponseEntity.created(new URI("/api/patients/{id}/echotests/" + result.getId()))
                .body(result);
    }

    @GetMapping(path="/echotests/{echoTestId}")
    public ResponseEntity<EchoTest> getEchoTest(@PathVariable Long echoTestId){
        Optional<EchoTest> result = echoTestRepository.findById(echoTestId);
        return result.map(response -> ResponseEntity.ok().body(response))
                .orElseThrow(() -> new ResourceNotFoundException("Echo Test with id " + echoTestId + " not found"));
    }

    @PutMapping("/echotests/{echoTestId}")
    ResponseEntity<EchoTest> updateEchoTest(@Valid @RequestBody EchoTest echoTest) {
        EchoTest result = echoTestRepository.save(echoTest);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/echotests/{echoTestId}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long echoTestId) {
        echoTestRepository.deleteById(echoTestId);
        return ResponseEntity.ok().build();
    }

}
