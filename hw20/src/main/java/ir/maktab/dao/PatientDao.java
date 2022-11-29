package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Patient;

public interface PatientDao extends BaseDao<Patient,Integer> {
    boolean isNationalCodeExist(String nationalCode);

    Patient findByNationalCode(String nationalCode);
}
