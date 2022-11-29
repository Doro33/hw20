package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;

import java.util.List;

public interface AppointmentService extends BaseService<Appointment,Integer> {
    List<Appointment> findPatientAppointments(Patient patient);

    List<Appointment> findDoctorAppointments(Doctor doctor);

    List<Appointment> findDoctorFreeAppointments(Doctor doctor);

    void addPatientToAppointment(Appointment appointment, Patient patient);
}