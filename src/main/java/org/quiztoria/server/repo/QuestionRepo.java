package org.quiztoria.server.repo;

import org.quiztoria.server.entities.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findAllByDateEndGreaterThanEqualAndDateStartLessThanEqual(Integer rangeStart, Integer rangeEnd);
    List<Question> findByDateEndGreaterThanEqualAndDateStartLessThanEqual(Integer rangeStart, Integer rangeEnd,  Pageable pageable);
}
