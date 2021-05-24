package pl.sda.project.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
public class Quiz {
    private long id;
    private String question;
    private String[] options;
    private String answer;
    private boolean accepted;

    public boolean isValidUserAnswer(UserAnswer userAnswer){
        return Objects.equals(answer, userAnswer.getAnswer());
    }
}
