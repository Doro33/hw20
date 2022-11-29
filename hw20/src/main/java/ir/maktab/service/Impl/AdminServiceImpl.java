package ir.maktab.service.Impl;

import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;
import ir.maktab.service.AdminService;
import ir.maktab.utils.AppContext;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public void showPatientInfo(Patient patient) {
        AppContext.getPATIENT_SER().showPatientInfo(patient);
    }

    @Override
    public List<Appointment> findDoctorAppointments(Doctor doctor) {
        return AppContext.getAPPOINTMENT_SER().findDoctorAppointments(doctor);
    }

    @Override
    public Appointment addAppointment(Appointment appointment) {
        if (appointment.getDoctor()==null)
            throw new NullPointerException("doctor cannot be null");
        if (appointment.getDate()==null)
            throw new  NullPointerException("date cannot be null");
        if (appointment.getHour()==null)
            throw new NullPointerException("hour cannot be null");
        if(appointment.getHour().isEmpty())
            throw new NullPointerException("hour cannot be null");
        return AppContext.getAPPOINTMENT_SER().save(appointment);
    }

    @Override
    public List<Appointment> findAllAppointments() {
        return AppContext.getAPPOINTMENT_SER().findAll();
    }
}
