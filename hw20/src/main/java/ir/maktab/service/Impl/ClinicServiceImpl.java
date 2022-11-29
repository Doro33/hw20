package ir.maktab.service.Impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.ClinicDao;
import ir.maktab.entity.Clinic;
import ir.maktab.service.ClinicService;

public class ClinicServiceImpl extends BaseServiceImpl<Clinic,Integer, ClinicDao>
implements ClinicService {
    public ClinicServiceImpl(ClinicDao repository) {
        super(repository);
    }
}
