package com.PanhaSim.HospitalAppoitment.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    public List<Appointment> findByPatientId(Long id);
    public List<Appointment> findByDoctorId(Long id);
}
