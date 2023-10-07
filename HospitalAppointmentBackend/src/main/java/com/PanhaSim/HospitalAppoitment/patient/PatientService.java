package com.PanhaSim.HospitalAppoitment.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    public Optional<Patient> getPatientsById(Long id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(Long id) {
        patientRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException("Patient with ID: "+id+" Cannot be found"));
        patientRepository.deleteById(id);
    }

    public void updatePatient(Long id, Patient patient) {
        Patient updatedPatient = patientRepository.findById(id).
                                                    orElseThrow(()->new IllegalArgumentException("Patient with ID: "+id+" Cannot be found"));
        updatedPatient.setFirst_name(patient.getFirst_name());
        updatedPatient.setLast_name(patient.getLast_name());
        updatedPatient.setDob(patient.getDob());
        updatedPatient.setGender(patient.getGender());
        updatedPatient.setAddress(patient.getAddress());
        updatedPatient.setEmail(patient.getEmail());
        updatedPatient.setPhone(patient.getPhone());

        patientRepository.save(updatedPatient);
    }

    public Patient findByName(String firstName, String lastName) {
        return patientRepository.findByFullName(firstName, lastName);
    }
}
