package pl.sda.project.controller;

import pl.sda.project.domain.UserAnswer;
import pl.sda.project.service.QuizService;
import pl.sda.project.view.core.ConsoleLooper;
import pl.sda.project.view.core.ConsoleView;
import pl.sda.project.view.core.Menu;
import pl.sda.project.view.core.MenuItem;
import pl.sda.project.view.domain.FillQuizByUserFromConsole;
import pl.sda.project.view.domain.InputNewQuizFromConsole;
import pl.sda.project.view.domain.PrintAllQuizFromConsole;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                "Wyświetl wszystkie quizy",
                () -> {
                    PrintAllQuizFromConsole printAllQuizFromConsole = new PrintAllQuizFromConsole(quizService.findAll());
                    printAllQuizFromConsole.print();
                }
        ));

//        menu.addMenuItem(new MenuItem(
//                "Wyświetl quiz o podanym id",
//                () -> AskUserForQuizIdFromConsole ask = new AskUserForQuizIdFromConsole(input)
//                long id = ask.AskForId();
//                quizService.findById(id).ifPresent(quiz ->
//                        new PrintAllQuizFromConsole(List.of())
//                        );
//        ));

        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        looper.runLoop();
    }
}
