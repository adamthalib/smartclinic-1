package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.Patient;
import com.mitrais.smartclinic.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/add")
    public String showPatientForm(Model model) {
        Patient patient = new Patient();
        model.addAttribute(patient);
        return "patients/form-add";
    }

    @PostMapping("/add")
    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/";
    }
}
