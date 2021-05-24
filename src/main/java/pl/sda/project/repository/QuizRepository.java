package pl.sda.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.sda.project.entity.QuizEntity;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    @Query("SELECT max(q.id) FROM QuizEntity q")
    long maxId();
}
