package pl.sda.project.controller;

import pl.sda.project.domain.UserAnswer;
import pl.sda.project.service.QuizService;
import pl.sda.project.view.core.ConsoleLooper;
import pl.sda.project.view.core.ConsoleView;
import pl.sda.project.view.core.Menu;
import pl.sda.project.view.core.MenuItem;
import pl.sda.project.view.console.domain.*;
import pl.sda.project.view.domain.FillQuizByUserFromConsole;
import pl.sda.project.view.domain.InputNewQuizFromConsole;

import java.util.Optional;
import java.util.Scanner;

public class QuizController {
    private final ConsoleLooper looper;
    private final ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public QuizController(QuizService quizService) {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        looper = new ConsoleLooper(view);

        menu.addMenuItem(new MenuItem(
                "Dodaj nowy quiz",
                () -> new InputNewQuizFromConsole(input).inputNewQuiz().ifPresent(quizService::addQuiz)
        ));

        menu.addMenuItem(new MenuItem(
                "Wypełnij losowy quiz",
                () -> quizService.findRandom().ifPresent(quiz -> {
                    Optional<UserAnswer> userAnswer = new FillQuizByUserFromConsole(input, quiz).fillQuiz();
                    userAnswer.ifPresent(answer -> {
                        if (quizService.isValidAnswer(answer)) {
                            view.printMessage("Brawo! Poprawna odpowiedź!");
                        } else {
                            view.printMessage("Ups! To nie jest poprawna odpowiedź!");
                        }

                    });
                })
        ));

        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        looper.runLoop();
    }
}
