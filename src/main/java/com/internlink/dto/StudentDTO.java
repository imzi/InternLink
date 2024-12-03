package com.internlink.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String phoneNumber;
    private List<String> skill;
    private String bio;
}
