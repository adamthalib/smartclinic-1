package com.mitrais.smartclinic.controller;

import com.mitrais.smartclinic.model.Patient;
import com.mitrais.smartclinic.repository.PatientRepository;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;


    @GetMapping
    public String patient(Model model){
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patients", patients);
        return "patients/patient";
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
        return "redirect:/patients";
    }
    @GetMapping(value = "/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id){
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}
