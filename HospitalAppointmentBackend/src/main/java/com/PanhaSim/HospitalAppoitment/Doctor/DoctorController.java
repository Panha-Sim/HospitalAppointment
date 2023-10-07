package com.PanhaSim.HospitalAppoitment.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getPatients(){
        return doctorService.getDoctors();
    }
    @PostMapping
    public void saveDoctor(@RequestBody Doctor doctor){
        doctorService.saveDoctor(doctor);
    }
    @GetMapping("{id}")
    public Optional<Doctor> getDoctorById(@PathVariable("id") Long id){
        return doctorService.getDoctorById(id);
    }
    @DeleteMapping("{id}")
    public void deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleteDoctor(id);
    }
    @PutMapping("{id}")
    public void updateDoctor(@PathVariable("id") Long id,
                              @RequestBody Doctor doctor){
        doctorService.updateDoctor(id, doctor);

    }
}
