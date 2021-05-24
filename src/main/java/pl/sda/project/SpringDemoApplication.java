package pl.sda.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.project.controller.QuizController;
import pl.sda.project.view.console.ConsoleLooper;
import pl.sda.project.domain.UserAnswer;
import pl.sda.project.service.QuizService;
import pl.sda.project.view.console.*;

import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    private final QuizController controller;

    public SpringDemoApplication(QuizService quizService) {
        controller = new QuizController(quizService);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        controller.start();
    }
}
