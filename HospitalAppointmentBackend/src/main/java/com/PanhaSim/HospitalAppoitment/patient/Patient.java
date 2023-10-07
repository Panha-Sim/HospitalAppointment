package com.PanhaSim.HospitalAppoitment.patient;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO,
            generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen",
            sequenceName="MY_ENTITY_SEQ")
    private long id;
    private String first_name;
    private String last_name;
    private LocalDate dob;
    private char gender;
    private String address;
    private String email;
    private Integer phone;

    public Patient() {
    }

    public Patient(String first_name,
                   String last_name,
                   LocalDate dob,
                   char gender,
                   String address,
                   String email,
                   Integer phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
