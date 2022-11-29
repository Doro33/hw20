package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Patient;



public interface PatientService extends BaseService<Patient, Integer> {
    boolean isNationalCodeExist(String nationalCode);

    Patient findByNationalCode(String nationalCode);

    void showPatientInfo(Patient patient);
}
