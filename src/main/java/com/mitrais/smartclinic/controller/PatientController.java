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

    private final
    PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    private String medicalRecordNumber(Integer id) {
        String mrn = "A";
        if (id < 10) {
            mrn = mrn + "000" + id.toString();
        } else if (id<100){
            mrn = mrn + "00" + id.toString();
        } else if(id<1000){
            mrn = mrn + "0" + id.toString();
        } else{
            mrn = mrn + id.toString();
        }
        return mrn;
    }

    @GetMapping("/add")
    public String showPatientForm(Model model) {
        Integer id = patientRepository.lastID();
        if(id == null){
            id = 1;
        } else {
            id = id++;
        }
        String mrn = medicalRecordNumber(id);
        Patient patient = new Patient();
        patient.setMedicalRecordNumber(mrn);
        model.addAttribute(patient);
        return "patients/form-add";
    }

    @PostMapping("/add")
    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "redirect:/";
    }
}
