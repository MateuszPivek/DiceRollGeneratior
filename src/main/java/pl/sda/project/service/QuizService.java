package pl.sda.project.service;

import pl.sda.project.domain.NewQuiz;
import pl.sda.project.domain.Quiz;
import pl.sda.project.domain.QuizForUser;
import pl.sda.project.domain.UserAnswer;

import java.util.List;
import java.util.Optional;

public interface QuizService {
    void addQuiz(NewQuiz newQuiz);
    Optional<QuizForUser> findById(long id);
    List<QuizForUser> findAll();
    Optional<QuizForUser> findRandom();
    boolean isValidAnswer(UserAnswer userAnswer);
}
