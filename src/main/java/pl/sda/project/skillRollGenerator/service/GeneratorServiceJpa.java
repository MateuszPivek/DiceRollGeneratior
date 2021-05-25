package pl.sda.project.skillRollGenerator.service;

import org.springframework.stereotype.Service;
import pl.sda.project.skillRollGenerator.domain.NewCharacter;
import pl.sda.project.skillRollGenerator.mapper.CharacterMapper;
import pl.sda.project.skillRollGenerator.repository.CharacterRepository;

import java.util.List;

@Service
public class GeneratorServiceJpa implements GeneratorService{
    private final CharacterRepository characterRepository;

    public GeneratorServiceJpa(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }


    @Override
    public void addCharacter(NewCharacter newCharacter) {
        characterRepository.save(CharacterMapper.INSTANCE.toEntity(newCharacter));
    }

    @Override
    public void removeCharacterById(long id) {
    }

    @Override
    public List<Character> findAllCharacters() {
        return null;
    }

    @Override
    public void attributesRoll() {

    }

    @Override
    public void skillsRoll() {

    }
}
