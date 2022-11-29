package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Patient;
import ir.maktab.entity.Prescription;

import java.util.List;

public interface PrescriptionService extends BaseService<Prescription,Integer> {
    List<Prescription> findPatientPrescriptions(Patient patient);
}
