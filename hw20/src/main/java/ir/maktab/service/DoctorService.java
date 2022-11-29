package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Clinic;
import ir.maktab.entity.Doctor;

import java.util.List;

public interface DoctorService extends BaseService<Doctor,Integer> {
    List<Doctor> findByClinic(Clinic clinic);
}
