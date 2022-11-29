package ir.maktab.dao.Impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.AppointmentDao;
import ir.maktab.entity.Appointment;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;
import ir.maktab.exception.NullIdException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AppointmentDaoImpl extends BaseDaoImpl<Appointment, Integer>
        implements AppointmentDao {
    public AppointmentDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Appointment> getEntityClass() {
        return Appointment.class;
    }

    @Override
    public List<Appointment> findPatientAppointments(Patient patient) {
        if (patient.getId() == null)
            throw new NullIdException("patient id cannot be null");


        TypedQuery<Appointment> query = entityManager
                .createQuery("select a from Appointment a " +
                        "where a.patient.id = :id", Appointment.class);
        query.setParameter("id", patient.getId());

        return query.getResultList();
    }

    @Override
    public List<Appointment> findDoctorAppointments(Doctor doctor) {
        if (doctor.getId() == null)
            throw new NullIdException("doctor's id cannot be null");

        TypedQuery<Appointment> query = entityManager
                .createQuery("select a from Appointment a " +
                        "where a.doctor.id = :id", Appointment.class);
        query.setParameter("id", doctor.getId());

        return query.getResultList();
    }

    @Override
    public List<Appointment> findDoctorFreeAppointments(Doctor doctor) {
        if (doctor.getId() == null)
            throw new NullIdException("doctor's id cannot be null");

        TypedQuery<Appointment> query = entityManager
                .createQuery("select a from Appointment a " +
                        "where a.doctor.id = :id " +
                        "and a.patient.id is null ", Appointment.class);
        query.setParameter("id", doctor.getId());

        return query.getResultList();
    }

    @Override
    public void addPatientToAppointment(Appointment appointment, Patient patient) {
        if (appointment.getId() == null)
            throw new NullIdException("appointment's id cannot be null");

        if (patient.getId() == null)
            throw new NullIdException("patient's id cannot be null");

        Query query = entityManager
                .createQuery("update Appointment as a "
                        + "set a.patient.id  = :pid " +
                        "where a.id = :aid ");

        query.setParameter("pid", patient.getId());
        query.setParameter("aid",appointment.getId());

        query.executeUpdate();

    }
}