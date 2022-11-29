package ir.maktab.dao.Impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.PrescriptionDao;
import ir.maktab.entity.Patient;
import ir.maktab.entity.Prescription;
import ir.maktab.exception.NullIdException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrescriptionDaoImpl extends BaseDaoImpl<Prescription,Integer> implements PrescriptionDao {
    public PrescriptionDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Prescription> getEntityClass() {
        return Prescription.class;
    }

    @Override
    public List<Prescription> findPatientPrescriptions(Patient patient) {
        if (patient.getId()==null)
            throw new NullIdException("patient's id cannot be null");

        TypedQuery<Prescription> query = entityManager
                .createQuery("select p from Prescription p " +
                                "where p.patient.id = :id "
                        , Prescription.class);
        query.setParameter("id", patient.getId());
        return query.getResultList();
    }
}
