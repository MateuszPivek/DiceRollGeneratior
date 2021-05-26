package pl.sda.project.skillRollGenerator.service;

import pl.sda.project.skillRollGenerator.domain.Character;
import pl.sda.project.skillRollGenerator.domain.NewCharacter;

import java.util.List;

public interface GeneratorService {
    void addCharacter (NewCharacter newCharacter);
    void removeCharacterById (long id);
    List<Character> findAllCharacters();
    void showAllCharacters();
    void attributesRollForCharacterById (long id);
    void skillsRoll ();
}
