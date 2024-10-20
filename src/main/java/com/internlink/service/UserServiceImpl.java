package com.internlink.service;

import com.internlink.dto.LoginDto;
import com.internlink.model.User;
import com.internlink.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user){
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            this.userRepository.save(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void login(LoginDto loginUser) {
        try {
            Optional<User> existingUser = userRepository.findByUsername(loginUser.getUsername());
            if (existingUser.isEmpty()) {
                throw new RuntimeException("User is not a valid user");
            } else {
                if (passwordEncoder.matches(loginUser.getPassword(), existingUser.get().getPassword())){
                    System.out.println("User is a valid user");
                }else {
                    throw new RuntimeException("Wrong password");
                }
            }
        }catch (Exception e){
            throw new RuntimeException("Exception on user login", e);
        }

    }


}
