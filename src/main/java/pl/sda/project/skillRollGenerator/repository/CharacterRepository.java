package pl.sda.project.skillRollGenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.project.skillRollGenerator.entity.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository <CharacterEntity, Long> {
    @Query("SELECT max(q.id) FROM CharacterEntity q")
    long maxId();
}
