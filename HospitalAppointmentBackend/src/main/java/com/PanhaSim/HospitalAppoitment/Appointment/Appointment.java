package com.PanhaSim.HospitalAppoitment.Appointment;

import jakarta.persistence.*;
import com.PanhaSim.HospitalAppoitment.patient.Patient;
import com.PanhaSim.HospitalAppoitment.Doctor.Doctor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,
            generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen",
            sequenceName="MY_ENTITY_SEQ")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
    private String text;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    public Appointment(){}
    public Appointment(
            Patient patient,
            Doctor doctor,
            String text,
            LocalDateTime startTime,
            LocalDateTime endTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.text = text;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", text='" + text + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
