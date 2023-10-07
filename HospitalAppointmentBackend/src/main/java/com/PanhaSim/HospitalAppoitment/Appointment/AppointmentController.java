package com.PanhaSim.HospitalAppoitment.Appointment;

import jakarta.transaction.Transactional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/appointment")
public class AppointmentController {
    AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAppointments(){
       return appointmentService.getAppointments();
    }

    @GetMapping("patient/{patientId}")
    public List<Appointment> getAppointmentOfPatient(@PathVariable("patientId") Long id){
        return appointmentService.getAppointmentOfPatient(id);
    }
    @GetMapping("doctor/{doctorId}")
    public List<Appointment> getAppointmentOfDoctor(@PathVariable("doctorId") Long id){
        return appointmentService.getAppointmentOfDoctor(id);
    }
    @PostMapping
    //@Transactional
    public void createAppointment(@RequestBody Appointment appointment){
        appointmentService.createAppointment(appointment);
    }

    @DeleteMapping("{id}")
    public void deleteAppointment(@PathVariable("id") Long id) throws NotFoundException {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("{id}")
    public void updateAppointment(@RequestBody Appointment appointment, @PathVariable("id") Long id) throws NotFoundException {
        appointmentService.updateAppointment(appointment, id);
    }

}
