package ir.maktab.view.menu.starter;

import ir.maktab.entity.Patient;
import ir.maktab.exception.LengthException;
import ir.maktab.utils.AppContext;

public class SignUp {
    private boolean lengthCheck(String input, int maxLength) {
        if (input.isEmpty()) {
            System.out.println("this field could not be empty.");
            return false;
        } else if (input.length() > maxLength) {
            System.out.println("this field cannot have more than " + maxLength + "characters.");
            return false;
        } else return true;
    }
    private String getString() {
        String input;
        while (true) {
            input = AppContext.getSCANNER().nextLine();
            if (input.matches("0")) {
                AppContext.getSTARTER_MENU().startMenu();
            }
            if (lengthCheck(input, 32))
                return input;
        }
    }

    private String setName() {
        System.out.print("name: ");
        return getString();
    }
    private String setNationalCode() {
        String nationalCode;
        while (true) {
            System.out.print("national code: ");
            nationalCode = AppContext.getSCANNER().nextLine();
            if (nationalCode.matches("0")) {
                AppContext.getSTARTER_MENU().startMenu();
            }
            if (!lengthCheck(nationalCode, 10))
                throw new LengthException("national code cannot have more than 10 characters");

            if (AppContext.getPATIENT_SER().isNationalCodeExist(nationalCode))
                System.out.println("this national code has already been taken.");
            else
                return nationalCode;
        }
    }

    private String setPassword() {
        System.out.print("password: ");
        return getString();
    }
    private Patient makePatient(){
        System.out.println("0) back.");
        return new Patient(setName(),setNationalCode(),setPassword());
    }
    public Patient SignUpPatient(){
        System.out.println("sign up:");
        Patient patient = makePatient();
        return AppContext.getPATIENT_SER().save(patient);
    }
}