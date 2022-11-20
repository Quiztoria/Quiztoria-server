package org.quiztoria.server.Dto;

import org.quiztoria.server.entities.User;
import org.quiztoria.server.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SimpleLogin {
    @Autowired
    UserRepo r;
    @Autowired
    PasswordEncoder enc;
    public SimpleLogin(LoginDto data){
        User u = r.findByEmail(data.getEmail());
        enc.encode(data.getPassword());
    }
}
