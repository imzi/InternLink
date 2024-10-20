package com.internlink.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryptionUtil {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Method to encode a password
    public static String encodePassword(String plainPassword) {
        return passwordEncoder.encode(plainPassword);
    }

    // Method to verify password during login
    public static boolean verifyPassword(String plainPassword, String encodedPassword) {
        return passwordEncoder.matches(plainPassword, encodedPassword);
    }

}
