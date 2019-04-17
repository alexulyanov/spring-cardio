package com.clinic.cardio.controllers;

import com.clinic.cardio.models.EchoTest;
import com.clinic.cardio.models.Patient;
import com.clinic.cardio.repositories.EchoTestRepository;
import com.clinic.cardio.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/patients/{patientId}")
public class EchoTestController {
    private static final String VIEWS_ECHOTESTS_CREATE_OR_UPDATE_FORM = "echotests/createOrUpdateEchoTestForm";
    private final EchoTestRepository echoTestRepository;
    private final PatientRepository patientRepository;

    public EchoTestController(PatientRepository patientRepository, EchoTestRepository echoTestRepository) {
        this.echoTestRepository = echoTestRepository;
        this.patientRepository = patientRepository;
    }

    @ModelAttribute("patient")
    public Patient findPatient(@PathVariable("patientId") Long patientId) {
        Optional<Patient> patient = this.patientRepository.findById(patientId);
        return patient.orElse(null);
    }

    @InitBinder("patient")
    public void initPatientBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @InitBinder("echotest")
    public void initEchoTestBinder(WebDataBinder dataBinder) { }

    @GetMapping("/echotests/new")
    public String initCreationForm(Patient patient, ModelMap model) {
        EchoTest echoTest = new EchoTest();
        patient.addEchoTest(echoTest);
        model.put("echoTest", echoTest);
        return VIEWS_ECHOTESTS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/echotests/new")
    public String processCreationForm(Patient patient, @Valid EchoTest echoTest, BindingResult result, ModelMap model) {
        if (StringUtils.hasLength(echoTest.getName()) && echoTest.isNew() && patient.getEchoTest(echoTest.getName(), true) != null){
            result.rejectValue("name", "duplicate", "already exists");
        }
        patient.addEchoTest(echoTest);
        if (result.hasErrors()) {
            model.put("echoTest", echoTest);
            return VIEWS_ECHOTESTS_CREATE_OR_UPDATE_FORM;
        } else {
            this.echoTestRepository.save(echoTest);
            return "redirect:/patients/{patientId}";
        }
    }

    @GetMapping("/echotests/{echoTestId}/edit")
    public String initUpdateForm(@PathVariable("echoTestId") Long echoTestId, ModelMap model) {
        Optional<EchoTest> echoTest = this.echoTestRepository.findById(echoTestId);
        echoTest.ifPresent(test -> model.put("echoTest", test));
        return VIEWS_ECHOTESTS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/echotests/{echoTestId}/edit")
    public String processUpdateForm(@Valid EchoTest echoTest, BindingResult result, Patient patient, ModelMap model) {
        if (result.hasErrors()) {
            echoTest.setPatient(patient);
            model.put("echoTest", echoTest);
            return VIEWS_ECHOTESTS_CREATE_OR_UPDATE_FORM;
        } else {
            patient.addEchoTest(echoTest);
            this.echoTestRepository.save(echoTest);
            return "redirect:/patients/{patientId}";
        }
    }
}
