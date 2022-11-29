package ir.maktab.dao.Impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.DoctorDao;
import ir.maktab.entity.Clinic;
import ir.maktab.entity.Doctor;
import ir.maktab.exception.NullIdException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DoctorDaoImpl extends BaseDaoImpl<Doctor,Integer> implements DoctorDao {
    public DoctorDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Doctor> getEntityClass() {
        return Doctor.class;
    }

    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        if (clinic.getId()==null)
            throw new NullIdException("clinic's id cannot be null");

        TypedQuery<Doctor> query = entityManager
                .createQuery("select d from Doctor d " +
                        "where d.clinic.id= :id " , Doctor.class);

        query.setParameter("id", clinic.getId());
        return query.getResultList();
    }
}