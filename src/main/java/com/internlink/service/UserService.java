package com.internlink.service;

import com.internlink.dto.LoginDto;
import com.internlink.model.User;

public interface UserService {
    void save(User user);
    void login(LoginDto loginUser);
}
