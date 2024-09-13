package com.internlink.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EndUser extends Base{
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private boolean isVerified;
}
