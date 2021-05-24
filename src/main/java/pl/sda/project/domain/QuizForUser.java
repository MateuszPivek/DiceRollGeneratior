package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizForUser {
    private long id;
    private String question;
    private String[] options;
}
