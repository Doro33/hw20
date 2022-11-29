package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Clinic;
import ir.maktab.entity.Doctor;

import java.util.List;

public interface DoctorDao extends BaseDao<Doctor,Integer> {
    List<Doctor> findByClinic(Clinic clinic);
}
