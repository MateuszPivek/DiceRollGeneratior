package pl.sda.project.skillRollGenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.project.skillRollGenerator.entity.CharacterEntity;

public interface CharacterRepository extends JpaRepository <CharacterEntity, Long> {

}
