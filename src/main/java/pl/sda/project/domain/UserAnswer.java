package pl.sda.project.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAnswer {
    private long quizId;
    private String username;
    private String answer;
}
