package pl.sda.project.skillRollGenerator.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterView {
    private long id;
    private String playerName;
    private String characterName;
    private String characterLastname;
    private int characterAge;
}
