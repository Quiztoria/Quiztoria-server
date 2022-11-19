package org.quiztoria.server;

import org.quiztoria.server.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {
}
