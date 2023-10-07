package com.PanhaSim.HospitalAppoitment.Doctor;

import jakarta.persistence.*;

@Entity
@Table
public class Doctor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,
            generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen",
            sequenceName="MY_ENTITY_SEQ")
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer phone;
    private String specialty;

    public Doctor(){}
    public Doctor(
            String first_name,
            String last_name,
            String email,
            Integer phone,
            String specialty) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", specialty='" + specialty + '\'' +
                '}';
    }
}
