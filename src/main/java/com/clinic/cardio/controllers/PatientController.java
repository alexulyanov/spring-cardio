package com.clinic.cardio.controllers;

import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Controller
public class PatientController {
//    TODO: Add view(html)
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
            this.patientRepository.save(patient);
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
            results = this.patientRepository.findByLastName(patient.getLastName());
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

}
