package ir.maktab.service.Impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.DoctorDao;
import ir.maktab.entity.Clinic;
import ir.maktab.entity.Doctor;
import ir.maktab.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl extends BaseServiceImpl<Doctor,Integer, DoctorDao> implements DoctorService {
    public DoctorServiceImpl(DoctorDao repository) {
        super(repository);
    }

    @Override
    public List<Doctor> findByClinic(Clinic clinic) {
        return repository.findByClinic(clinic);
    }
}
