package com.internlink.service;

import com.internlink.model.EndUser;
import com.internlink.repository.EndUserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EndUserServiceImpl implements EndUserService{
    private final EndUserRepository userRepository;

    public EndUserServiceImpl(EndUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String save() {
        UUID uuid = UUID.randomUUID();
        EndUser user = new EndUser();
        user.setId(uuid);
        user.setFirstname("Imthath");
        user.setLastname("Abbas");
        user.setCreatedAt(LocalDateTime.now());
        user.setVerified(true);
        userRepository.save(user);
        return user.toString();
    }

    @Override
    public List<String> test() {
        return userRepository.findAll()
                .stream()
                .map(EndUser::getFirstname)
                .collect(Collectors.toList());
    }
}
