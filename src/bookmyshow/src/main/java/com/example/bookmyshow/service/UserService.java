package com.example.bookmyshow.service;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signUp(String name, String password) {


        User user = new User();
        user.setUsername(name);
        user.setPassword(passwordEncoder.encode(password));

        user = userRepository.save(user);
        return user;
    }

    public boolean login(String email, String password) {
        return passwordEncoder.matches(password, userRepository.findByUsername(email).get().getPassword());

    }
}
