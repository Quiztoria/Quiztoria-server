package org.quiztoria.server.repo;

import org.quiztoria.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User,Long> {
    User findByEmail(String Email);
    Boolean existsByEmail(String Email);

}
