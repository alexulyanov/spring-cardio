package com.clinic.cardio.controllers;

import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository cardioService) {
        this.patientRepository = cardioService;
    }

    @GetMapping("/patients/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("patient", new Patient());
        return "patients/findPatients";
    }

    @GetMapping("/patients")
    public String performSearch(Patient patient, BindingResult result, Map<String, Object> model) {
        return "patients/patients";
    }
}
