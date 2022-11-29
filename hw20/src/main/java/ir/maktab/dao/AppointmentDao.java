package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;

import java.util.List;

public interface AppointmentDao extends BaseDao<Appointment,Integer> {
    List<Appointment> findPatientAppointments(Patient patient);

    List<Appointment> findDoctorAppointments(Doctor doctor);

    List<Appointment> findDoctorFreeAppointments(Doctor doctor);


    void addPatientToAppointment(Appointment appointment, Patient patient);
}
