package ir.maktab.dao.Impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.PatientDao;
import ir.maktab.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;



public class PatientDaoImpl extends BaseDaoImpl<Patient, Integer> implements PatientDao {
    public PatientDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public boolean isNationalCodeExist(String nationalCode) {
        TypedQuery<Long> query = entityManager
                .createQuery("select count(p.id)from Patient p " +
                                "where p.nationalCode = :nc "
                        , Long.class);
        query.setParameter("nc", nationalCode);
        return query.getSingleResult() == 1;
    }

    @Override
    public Patient findByNationalCode(String nationalCode) {
        TypedQuery<Patient> query = entityManager
                .createQuery("select p from Patient p " +
                                "where p.nationalCode = :nc "
                        , Patient.class
                );
        query.setParameter("nc", nationalCode);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }
}