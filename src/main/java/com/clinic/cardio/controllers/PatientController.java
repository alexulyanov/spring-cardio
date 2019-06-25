package com.clinic.cardio.controllers;

import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Controller
public class PatientController {
    private static final String VIEWS_PATIENT_CREATE_OR_UPDATE_FORM = "patients/createOrUpdatePatientForm";
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository cardioService) {
        this.patientRepository = cardioService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/patients/new")
    public String initCreationForm(Map<String, Object> model) {
        Patient patient = new Patient();
        model.put("patient", patient);
        return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/patients/new")
    public String processCreationForm(@Valid Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
        } else {
            try {
                this.patientRepository.save(patient);
            } catch (Exception e) {
                result.addError(new FieldError("patient", "ohip", "This OHIP already exists"));
                return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
            }
            return "redirect:/patients/" + patient.getId();
        }
    }

    @GetMapping("/patients/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("patient", new Patient());
        return "patients/findPatients";
    }

    @GetMapping("/patients")
    public String performSearch(Patient patient, BindingResult result, Map<String, Object> model) {
        // allow parameterless GET request for /patients to return all records
        Collection<Patient> results;
        if (patient.getLastName() == null || patient.getLastName().equals("")) {
            results = this.patientRepository.findAll();
        } else {
            results = this.patientRepository.findByOhip(patient.getOhip());
        }

        // find patients by last name
        if (results.isEmpty()) {
            // no patients found
            result.rejectValue("lastName", "notFound", "not found");
            return "patients/findPatients";
        } else if (results.size() == 1) {
            // 1 patient found
            patient = results.iterator().next();
            return "redirect:/patients/" + patient.getId();
        } else {
            // multiple patients found
            model.put("selections", results);
            return "patients/patientsList";
        }
    }

    @GetMapping("/patients/{patientId}")
    public ModelAndView showPatient(@PathVariable("patientId") Long patientId) {
        ModelAndView mav = new ModelAndView("patients/patientDetails");
        Optional<Patient> patient = this.patientRepository.findById(patientId);
        if (!patient.isPresent()) {
//          TODO: Log Error
            System.out.println("Could not retrieve patient from database");
        } else {
            mav.addObject(patient.get());
        }

//        Syntax for Java >= 9
//        this.patientRepository.findById(patientId).ifPresentOrElse(patient -> mav.addObject(patient), () -> logger.error("..."));

        return mav;
    }

    @GetMapping("/patients/{patientId}/edit")
    public String initUpdatePatientForm(@PathVariable("patientId") Long patientId, Model model) {
        Optional<Patient> patient = this.patientRepository.findById(patientId);
        patient.ifPresent(value -> model.addAttribute("patient", value));
        return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/patients/{patientId}/edit")
    public String processUpdatePatientForm(@Valid Patient patient, BindingResult result, @PathVariable("patientId") Long patientId) {
        if (result.hasErrors()) {
            return VIEWS_PATIENT_CREATE_OR_UPDATE_FORM;
        } else {
            patient.setId(patientId);
            this.patientRepository.save(patient);
            return "redirect:/patients/{patientId}";
        }
    }

}
