package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.Patient;
import com.mitrais.smartclinic.repository.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "patients/form-add";
        }
        patientRepository.save(patient);
        return "redirect:/";
    }
}
