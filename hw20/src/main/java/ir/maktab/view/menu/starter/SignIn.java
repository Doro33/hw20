package ir.maktab.view.menu.starter;

import ir.maktab.entity.Patient;
import ir.maktab.utils.AppContext;

public class SignIn {
    private String setNationalCode(){
        String nationalCode;
        while (true){
            System.out.print("national code: ");
            nationalCode= AppContext.getSCANNER().nextLine();
            if(nationalCode.matches("0")) {
                AppContext.getSTARTER_MENU().startMenu();
                break;
            }if(!AppContext.getPATIENT_SER().isNationalCodeExist(nationalCode))
                System.out.println("incorrect national code .");
            else
                break;
        }
        return nationalCode;
    }
    public Patient logIn(){
        System.out.println("sign in:");
        System.out.println("0) back.");
        String nationalCode= setNationalCode();
        Patient patient = AppContext.getPATIENT_SER().findByNationalCode(nationalCode);
        String correctPassword=patient.getPassword();
        String inputPassword;
        while (true){
            System.out.print("password: ");
            inputPassword=AppContext.getSCANNER().nextLine();
            if(inputPassword.matches("0")){
                AppContext.getSTARTER_MENU().startMenu();
                break;
            }
            if (!inputPassword.equals(correctPassword))
                System.out.println("this password is incorrect.");
            else
                return patient;
        }
        return null;
    }
}