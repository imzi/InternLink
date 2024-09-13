package com.internlink.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Base {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(updatable = false, nullable = false, unique = true)
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
