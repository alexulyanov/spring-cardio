package com.clinic.cardio.controllers;

import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Controller
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository cardioService) {
        this.patientRepository = cardioService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/patients/find")
    public String initFindForm(Map<String, Object> model) {
        model.put("patient", new Patient());
        return "patients/findPatients";
    }

    @GetMapping("/patients")
    public String performSearch(Patient patient, BindingResult result, Map<String, Object> model) {
        // allow parameterless GET request for /owners to return all records
        Collection<Patient> results;
        if (patient.getLastName() == null || patient.getLastName().equals("")) {
            results = this.patientRepository.findAll();
        } else {
            results = this.patientRepository.findByLastName(patient.getLastName());
        }

        // find owners by last name
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "patients/findPatients";
        } else if (results.size() == 1) {
            // 1 owner found
            patient = results.iterator().next();
            return "redirect:/patients/" + patient.getId();
        } else {
            // multiple owners found
            model.put("selections", results);
            return "patients/patientsList";
        }
    }

    @GetMapping("/patients/{patientId}")
    public ModelAndView showOwner(@PathVariable("patientId") Long patientId) {
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
