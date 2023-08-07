package com.hami.springbootexamples.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserInputModel {
    @NotEmpty
    @Size(min = 2,message = "user name should have at least 2 characters.")
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 8 , message = "password should have at least 8 characters.")
    private String password;
}
