package com.PanhaSim.HospitalAppoitment.Doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {    
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Doctor with ID: "+id+" Cannot be found"));
        doctorRepository.deleteById(id);
    }

    public void updateDoctor(Long id, Doctor doctor) {
        Doctor updatedDoctor = doctorRepository.findById(id).
                orElseThrow(()->new IllegalArgumentException("Doctor with ID: "+id+" Cannot be found"));
        updatedDoctor.setFirst_name(doctor.getFirst_name());
        updatedDoctor.setLast_name(doctor.getLast_name());
        updatedDoctor.setEmail(doctor.getEmail());
        updatedDoctor.setPhone(doctor.getPhone());
        updatedDoctor.setSpecialty(doctor.getSpecialty());

        doctorRepository.save(updatedDoctor);
    }
}
