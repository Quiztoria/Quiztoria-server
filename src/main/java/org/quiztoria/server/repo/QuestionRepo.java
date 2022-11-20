package org.quiztoria.server.repo;

import org.quiztoria.server.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {

}
