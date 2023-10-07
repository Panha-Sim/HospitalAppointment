package com.PanhaSim.HospitalAppoitment.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }
    @PostMapping
    public void savePatient(@RequestBody Patient patient){
        patientService.savePatient(patient);
    }
    @GetMapping("{id}")
    public Optional<Patient> getPatientById(@PathVariable("id") Long id){
        return patientService.getPatientsById(id);
    }
    @DeleteMapping("{id}")
    public void deletePatient(@PathVariable("id") Long id){
        patientService.deletePatient(id);
    }
    @PutMapping("{id}")
    public void updatePatient(@PathVariable("id") Long id,
                              @RequestBody Patient patient){
        patientService.updatePatient(id, patient);
    }

    @GetMapping("/fullName")
    public Patient findByName(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName){
        return patientService.findByName(firstName, lastName);
    }


}
