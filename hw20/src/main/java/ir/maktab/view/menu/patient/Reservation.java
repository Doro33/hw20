package ir.maktab.view.menu.patient;

import ir.maktab.entity.Appointment;
import ir.maktab.entity.Clinic;
import ir.maktab.entity.Doctor;
import ir.maktab.entity.Patient;
import ir.maktab.utils.AppContext;

import java.util.List;

public class Reservation {
    private Clinic chooseClinic(Patient patient) {
        List<Clinic> clinics = AppContext.getCLINIC_SER().findAll();
        System.out.println("0) back");
        AppContext.listPrinter(clinics);
        int inputNumber;
        while (true) {
            try {
                inputNumber = AppContext.getSCANNER().nextInt();
                if (inputNumber == 0)
                    AppContext.getPATIENT_MENU().startMenu(patient);
                if (0 < inputNumber && inputNumber <= clinics.size())
                    return clinics.get(inputNumber-1);
                else
                    System.out.println("you can choose between 0 _ "+clinics.size());
            } catch (Exception e) {
                System.out.println("you must enter an integer");
            }
        }
    }

    private Doctor chooseDoctor(Patient patient, Clinic clinic){
        List<Doctor> clinicDoctors = AppContext.getDOCTOR_SER().findByClinic(clinic);
        System.out.println("0) back");
        AppContext.listPrinter(clinicDoctors);
        int inputNumber;
        while (true) {
            try {
                inputNumber = AppContext.getSCANNER().nextInt();
                if (inputNumber == 0)
                    AppContext.getPATIENT_MENU().startMenu(patient);
                if (0 < inputNumber && inputNumber <= clinicDoctors.size())
                    return clinicDoctors.get(inputNumber-1);
                else
                    System.out.println("you can choose between 0 _ "+clinicDoctors.size());
            } catch (Exception e) {
                System.out.println("you must enter an integer");
            }
        }
    }

    private Appointment chooseAppointment(Patient patient,Doctor doctor){
        List<Appointment> freeAppointments = AppContext.getAPPOINTMENT_SER().findDoctorFreeAppointments(doctor);
        System.out.println("0) back");
        AppContext.listPrinter(freeAppointments);
        int inputNumber;
        while (true) {
            try {
                inputNumber = AppContext.getSCANNER().nextInt();
                if (inputNumber == 0)
                    AppContext.getPATIENT_MENU().startMenu(patient);
                if (0 < inputNumber && inputNumber <= freeAppointments.size())
                    return freeAppointments.get(inputNumber-1);
                else
                    System.out.println("you can choose between 0 _ "+freeAppointments.size());
            } catch (Exception e) {
                System.out.println("you must enter an integer");
            }
        }
    }

    private static boolean confirm() {
        System.out.println("Do you confirm?");
        String input;
        while (true) {
            System.out.print("(y:yes n:no): ");
            input = AppContext.getSCANNER().next();
            switch (input.toLowerCase()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("invalid input.");
            }
        }
    }

    public void reserveAppointment(Patient patient){
        Clinic clinic = chooseClinic(patient);
        Doctor doctor = chooseDoctor(patient,clinic);
        Appointment appointment = chooseAppointment(patient,doctor);
        System.out.println(appointment);
        if (confirm()) {
            AppContext.getAPPOINTMENT_SER().addPatientToAppointment(appointment, patient);
            AppContext.doneReaction();
        }
        AppContext.getPATIENT_MENU().startMenu(patient);
    }
}