package ir.maktab.view.menu.starter;

import ir.maktab.entity.Patient;
import ir.maktab.utils.AppContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarterMenu {
    private final List<String> menuItems;
    public StarterMenu(){
        this.menuItems = new ArrayList<>();
        this.menuItems.addAll(Arrays.asList("sign in","sign up","exit"));
    }
    public void startMenu(){
        AppContext.listPrinter(menuItems);
        System.out.print("what do you want to do: ");
        String input;
        boolean stayInLoop = true;
        while (stayInLoop) {
            input=AppContext.getSCANNER().nextLine();
            switch (input) {
                case "1" -> {
                    Patient patient = AppContext.getSIGN_IN().logIn();
                    AppContext.getPATIENT_MENU().startMenu(patient);
                    stayInLoop = false;
                }
                case "2" -> {
                    Patient patient = AppContext.getSIGN_UP().SignUpPatient();
                    AppContext.getPATIENT_MENU().startMenu(patient);
                    stayInLoop = false;
                }
                case "3" -> {
                    exitCheck();
                    stayInLoop = false;
                }
                default -> {
                    System.out.println("your input is not valid.");
                    System.out.print("you can only choose 1-3 : ");
                }
            }
        }
    }

    public void exitCheck(){
        System.out.println("are you sure you want to exit?");
        String input;
        boolean stayInLoop = true;
        while (stayInLoop) {
            System.out.print("y as yes / n as no: ");
            input = AppContext.getSCANNER().nextLine().toLowerCase();
            if (input.matches("y")) {
                System.out.println("good bye.");
                System.exit(0);
            } else if (input.matches("n")) {
                startMenu();
                stayInLoop = false;
            } else
                System.out.println("your input is not valid.");
        }
    }
}