package ir.maktab.service.Impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.PrescriptionDao;
import ir.maktab.entity.Patient;
import ir.maktab.entity.Prescription;
import ir.maktab.service.PrescriptionService;

import java.util.List;

public class PrescriptionServiceImpl extends BaseServiceImpl<Prescription,Integer, PrescriptionDao>
        implements PrescriptionService {
    public PrescriptionServiceImpl(PrescriptionDao repository) {
        super(repository);
    }

    @Override
    public List<Prescription> findPatientPrescriptions(Patient patient) {
        return repository.findPatientPrescriptions(patient);
    }
}
