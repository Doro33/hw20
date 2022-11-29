package ir.maktab.utils;

import ir.maktab.dao.*;
import ir.maktab.dao.Impl.*;
import ir.maktab.service.*;
import ir.maktab.service.Impl.*;
import ir.maktab.view.menu.patient.PatientMenu;
import ir.maktab.view.menu.patient.Reservation;
import ir.maktab.view.menu.starter.SignIn;
import ir.maktab.view.menu.starter.SignUp;
import ir.maktab.view.menu.starter.StarterMenu;
import jakarta.persistence.EntityManager;
import lombok.Getter;


import java.util.List;
import java.util.Scanner;

public class AppContext {
    private AppContext() {
    }


    public static Scanner getSCANNER() {
        return new Scanner(System.in);
    }

    private static final EntityManager ENTITY_MANAGER =
            HibernateUtils.getENTITY_MANAGER_FACTORY().createEntityManager();

    private static final PatientDao PATIENT_DAO = new PatientDaoImpl(ENTITY_MANAGER);
    @Getter
    private static final PatientService PATIENT_SER = new PatientServiceImpl(PATIENT_DAO);

    private static final PrescriptionDao PRESCRIPTION_DAO = new PrescriptionDaoImpl(ENTITY_MANAGER);
    @Getter
    private static final PrescriptionService PRESCRIPTION_SER = new PrescriptionServiceImpl(PRESCRIPTION_DAO);

    private static final DoctorDao DOCTOR_DAO = new DoctorDaoImpl(ENTITY_MANAGER);
    @Getter
    private static final DoctorService DOCTOR_SER = new DoctorServiceImpl(DOCTOR_DAO);

    @Getter
    private static final AdminService ADMIN_SER = new AdminServiceImpl();

    private static final ClinicDao CLINIC_DAO = new ClinicDaoImpl(ENTITY_MANAGER);
    @Getter
    private static final ClinicService CLINIC_SER = new ClinicServiceImpl(CLINIC_DAO);

    private static final AppointmentDao APPOINTMENT_DAO = new AppointmentDaoImpl(ENTITY_MANAGER);
    @Getter
    private static final AppointmentService APPOINTMENT_SER = new AppointmentServiceImpl(APPOINTMENT_DAO);
    @Getter
    private static final StarterMenu STARTER_MENU = new StarterMenu();
    @Getter
    private static final SignUp SIGN_UP = new SignUp();
    @Getter
    private static final SignIn SIGN_IN = new SignIn();
    @Getter
    private static final PatientMenu PATIENT_MENU = new PatientMenu();
    @Getter
    private static final Reservation RESERVATION = new Reservation();

    public static void listPrinter(List input) {
        if (input.isEmpty())
            System.out.println("The list is empty.");
        for (int i = 0; i < input.size(); i++)
            System.out.println(i + 1 + ") " + input.get(i));
    }

    public static void doneReaction() {
        System.out.println("Done.");
        System.out.println("Press Enter To Continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}