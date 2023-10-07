package com.PanhaSim.HospitalAppoitment.Appointment;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    public List<Appointment> getAppointmentOfPatient(Long id){
        return appointmentRepository.findByPatientId(id);
    }

    public List<Appointment> getAppointmentOfDoctor(Long id) {
        return appointmentRepository.findByDoctorId(id);
    }

    public void createAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) throws NotFoundException {
        appointmentRepository.findById(id).
                orElseThrow(()->new NotFoundException("appointment with id "+id+" cannot be found"));
        appointmentRepository.deleteById(id);
    }

    public void updateAppointment(Appointment appointment, Long id) throws NotFoundException {
        Appointment updatedAppointment = appointmentRepository.findById(id).
                orElseThrow(()->new NotFoundException("appointment with id "+id+" cannot be found"));
         updatedAppointment.setText(appointment.getText());
         updatedAppointment.setStartTime(appointment.getStartTime());
         updatedAppointment.setEndTime(appointment.getEndTime());

         appointmentRepository.save(updatedAppointment);
    }
}
