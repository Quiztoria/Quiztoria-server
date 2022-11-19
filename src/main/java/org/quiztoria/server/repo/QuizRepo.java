package org.quiztoria.server.repo;

import org.quiztoria.server.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
