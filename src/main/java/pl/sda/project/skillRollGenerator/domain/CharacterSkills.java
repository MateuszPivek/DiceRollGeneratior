package pl.sda.project.skillRollGenerator.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacterSkills {
    private long id;
    private String characterName;
    private String characterLastname;
    private Integer[] skills;
}
