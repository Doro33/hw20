package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Patient;
import ir.maktab.entity.Prescription;

import java.util.List;

public interface PrescriptionDao extends BaseDao<Prescription,Integer> {
    List<Prescription> findPatientPrescriptions(Patient patient);
}
