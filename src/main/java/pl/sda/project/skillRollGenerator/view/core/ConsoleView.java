package pl.sda.project.skillRollGenerator.view.core;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleView {
    private final Menu menu;
    private final Scanner scanner;

    public ConsoleView(Menu menu, InputStream inputStream) {
        this.menu = menu;
        this.scanner = new Scanner(inputStream);
    }

    public boolean printAndSelectMenuOption(){
        menu.print();
        if(scanner.hasNextInt()) {
            int option = scanner.nextInt();
            scanner.nextLine();
            return menu.process(option);
        }
        scanner.nextLine();
        return false;
    }

    public void printMessage (String message) {
        System.out.println(message);
    }

    public static void clearScreen(){
        System.out.flush();
    }
}
