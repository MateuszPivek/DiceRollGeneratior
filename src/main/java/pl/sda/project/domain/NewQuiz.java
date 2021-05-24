package pl.sda.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewQuiz {
    private String question;
    private String[] options;
    private String answer;
}
