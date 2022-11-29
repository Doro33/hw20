package ir.maktab.service.Impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.PatientDao;
import ir.maktab.entity.Patient;
import ir.maktab.exception.NullIdException;
import ir.maktab.service.PatientService;
import ir.maktab.utils.AppContext;

public class PatientServiceImpl extends BaseServiceImpl<Patient,Integer, PatientDao> implements PatientService {
    public PatientServiceImpl(PatientDao repository) {
        super(repository);
    }

    @Override
    public boolean isNationalCodeExist(String nationalCode) {
        return repository.isNationalCodeExist(nationalCode);
    }

    @Override
    public Patient findByNationalCode(String nationalCode) {
        return repository.findByNationalCode(nationalCode);
    }

    @Override
    public void showPatientInfo(Patient patient) {
        if (patient.getId() == null)
            throw new NullIdException("patient id cannot be null");

        System.out.println("personal info:");
        System.out.println(findById(patient.getId()));

        System.out.println("appointments:");
        AppContext.listPrinter(
                AppContext.getAPPOINTMENT_SER()
                        .findPatientAppointments(patient)
        );

        System.out.println("prescriptions");
        AppContext.listPrinter(
                AppContext.getPRESCRIPTION_SER()
                        .findPatientPrescriptions(patient)
        );
    }
}
