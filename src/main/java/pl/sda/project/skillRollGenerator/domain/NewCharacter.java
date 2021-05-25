package pl.sda.project.skillRollGenerator.domain;

import lombok.Builder;
import lombok.Data;

    @Data
    @Builder
    public class NewCharacter {
        private String playerName;
        private String characterName;
        private String characterLastname;
        private int characterAge;
        private Integer[] attributes;
        private Integer[] skills;
}
