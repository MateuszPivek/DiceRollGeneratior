package pl.sda.project.skillRollGenerator.controller;

import pl.sda.project.skillRollGenerator.service.GeneratorService;
import pl.sda.project.skillRollGenerator.view.core.ConsoleLooper;
import pl.sda.project.skillRollGenerator.view.core.ConsoleView;
import pl.sda.project.skillRollGenerator.view.core.Menu;
import pl.sda.project.skillRollGenerator.view.core.MenuItem;
import pl.sda.project.skillRollGenerator.view.domain.InputNewCharacterFromConsole;

import java.util.Scanner;

public class GeneratorController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public GeneratorController (GeneratorService generatorService){
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(new MenuItem(
                "Dodaj nową postać",
                () -> new InputNewCharacterFromConsole(input).inputNewCharacter().ifPresent(generatorService::addCharacter)
        ));

        menu.addMenuItem(new MenuItem(
                "Wyjdź",
                Menu.DEFAULT_QUIT
        ));
    }
    public void start() {
        looper.runLoop();
    }
}
