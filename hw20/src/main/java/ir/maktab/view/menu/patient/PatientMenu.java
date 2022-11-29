package ir.maktab.view.menu.patient;

import ir.maktab.entity.Patient;
import ir.maktab.utils.AppContext;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
public class PatientMenu {
    private final List<String> menuItems;
    public PatientMenu(){
        this.menuItems = new ArrayList<>();
        this.menuItems.addAll(Arrays.asList("my info","reserve an appointment","exit"));
    }
    public void startMenu(Patient patient){
        String input;
        boolean stayInLoop = true;
        while (stayInLoop) {
            AppContext.listPrinter(menuItems);
            System.out.print("what do you want to do: ");
            input=AppContext.getSCANNER().nextLine();
            switch (input) {
                case "1" -> {
                    AppContext.getPATIENT_SER().showPatientInfo(patient);
                    AppContext.doneReaction();

                }
                case "2" -> {
                    AppContext.getRESERVATION().reserveAppointment(patient);
                    stayInLoop = false;
                }
                case "3" -> {
                    exitCheck(patient);
                    stayInLoop = false;
                }
                default -> {
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-3 : ");
                }
            }
        }
    }

    public void exitCheck(Patient patient){
        System.out.println("are you sure you want to exit?");
        String input;
        boolean stayInLoop = true;
        while (stayInLoop) {
            System.out.print("y as yes / n as no: ");
            input = AppContext.getSCANNER().nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("good bye.");
                AppContext.getSTARTER_MENU().startMenu();
            } else if (input.matches("n")) {
                startMenu(patient);
                stayInLoop = false;
            } else
                System.out.println("your input is not valid.");
        }
    }
}