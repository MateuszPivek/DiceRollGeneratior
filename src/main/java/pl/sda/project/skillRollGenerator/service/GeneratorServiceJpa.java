package pl.sda.project.skillRollGenerator.service;

import org.springframework.stereotype.Service;
import pl.sda.project.skillRollGenerator.domain.Character;
import pl.sda.project.skillRollGenerator.domain.NewCharacter;
import pl.sda.project.skillRollGenerator.entity.CharacterEntity;
import pl.sda.project.skillRollGenerator.mapper.CharacterMapper;
import pl.sda.project.skillRollGenerator.repository.CharacterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneratorServiceJpa implements GeneratorService{
    private final CharacterRepository characterRepository;


    public GeneratorServiceJpa(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;

    }

    @Override
    public void addCharacter(NewCharacter newCharacter) {
        characterRepository.save(CharacterMapper.INSTANCE.toEntity(newCharacter));
    }

    @Override
    public void removeCharacterById(long id) {
        //TODO zrobić ifa żeby usuwał postać gdy id jest zgodne ale wyrzucał powiadomienie gdy nie ma postaci o takim id
        characterRepository.deleteById(id);
    }

    @Override
    public List<Character> findAllCharacters() {
        return characterRepository.findAll().stream().map(CharacterMapper.INSTANCE::toFront).collect(Collectors.toList());
    }

    @Override
    public void showAllCharacters() {
        System.out.println(findAllCharacters());
    }


    @Override
    public void attributesRollForCharacterById(long id) {
        //TODO przerobić metodę aby wyszukiwała konkretne atrybuty i dla nich wykonywać rolla
        int maxRoll = 100;
        int minRoll = 1;
        int randomRoll = (int)(Math.random() * (maxRoll - minRoll) + minRoll);
        System.out.println(characterRepository.findById(id).stream().map(CharacterMapper.INSTANCE::toAttributesRoll).collect(Collectors.toList()));

    }

    @Override
    public void skillsRoll() {

    }
}
