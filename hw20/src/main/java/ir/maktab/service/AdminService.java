package ir.maktab.service;

import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;

import java.util.List;

public interface AdminService {
    void showPatientInfo(Patient patient);

    List<Appointment> findDoctorAppointments(Doctor doctor);

    Appointment addAppointment(Appointment appointment);

    List<Appointment> findAllAppointments();
}
