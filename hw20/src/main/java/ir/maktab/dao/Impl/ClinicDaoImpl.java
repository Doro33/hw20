package ir.maktab.dao.Impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.ClinicDao;
import ir.maktab.entity.Clinic;
import jakarta.persistence.EntityManager;

public class ClinicDaoImpl extends BaseDaoImpl<Clinic,Integer> implements ClinicDao {
    public ClinicDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Clinic> getEntityClass() {
        return Clinic.class;
    }
}
