package org.quiztoria.server;

import org.quiztoria.server.entities.User;
import org.quiztoria.server.repo.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        User user = userRepo.findByEmail(Email);
        if (user==null) {
            throw new UsernameNotFoundException(Email);
        }else{
            builder = org.springframework.security.core.userdetails.User.withUsername(Email);
            builder.password(user.getPassword());
            builder.authorities("ROLE_ADMIN");
            System.out.println(user.getPassword());
        }
        return builder.build();

    }


}