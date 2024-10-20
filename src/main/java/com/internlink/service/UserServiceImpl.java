package com.internlink.service;

import com.internlink.model.User;
import com.internlink.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user){
        try {
            this.userRepository.save(user);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
