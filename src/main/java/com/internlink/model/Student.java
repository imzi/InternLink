package com.internlink.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "student")
public class Student {
    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false, unique = true)
    private String id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String username;
    @Email
    @Column(unique = true)
    private String email;
    private String phoneNumber;
    @ElementCollection
    private List<String> skill;
    private String bio;

    @PrePersist
    private void generateId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}
