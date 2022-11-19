package org.quiztoria.server.repo;

import org.quiztoria.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
