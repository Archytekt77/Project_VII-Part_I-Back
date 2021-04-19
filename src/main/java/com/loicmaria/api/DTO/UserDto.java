package com.loicmaria.api.DTO;

import lombok.Data;

@Data
public class UserDto {

    private int id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;
}
