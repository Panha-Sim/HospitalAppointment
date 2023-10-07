package com.PanhaSim.HospitalAppoitment.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM Patient p WHERE p.first_name = :firstName AND p.last_name = :lastName")
    Patient findByFullName(String firstName, String lastName);
}
