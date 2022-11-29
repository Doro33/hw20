package ir.maktab.service.Impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.AppointmentDao;
import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;
import ir.maktab.service.AppointmentService;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class AppointmentServiceImpl extends BaseServiceImpl<Appointment,Integer, AppointmentDao>
implements AppointmentService {
    public AppointmentServiceImpl(AppointmentDao repository) {
        super(repository);
    }

    @Override
    public List<Appointment> findPatientAppointments(Patient patient) {
        return repository.findPatientAppointments(patient);
    }

    @Override
    public List<Appointment> findDoctorAppointments(Doctor doctor) {
        return repository.findDoctorAppointments(doctor);
    }

    @Override
    public List<Appointment> findDoctorFreeAppointments(Doctor doctor) {
        return repository.findDoctorFreeAppointments(doctor);
    }

    @Override
    public void addPatientToAppointment(Appointment appointment, Patient patient) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        try {
            transaction.begin();
            repository.addPatientToAppointment(appointment,patient);
            transaction.commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            transaction.rollback();
        }
    }
}