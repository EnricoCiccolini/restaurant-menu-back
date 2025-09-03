package org.lesson.java.menu.restaurant_menu.security;

import java.util.Optional;

import org.lesson.java.menu.restaurant_menu.model.User;
import org.lesson.java.menu.restaurant_menu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userAttem = userRepository.findByUsername(username);
        if (username.isEmpty()) {
            throw new UsernameNotFoundException("there ara no users avaiable whit username " + username);
        }

        return new DatabaseUserDetails(userAttem.get());
    }

}