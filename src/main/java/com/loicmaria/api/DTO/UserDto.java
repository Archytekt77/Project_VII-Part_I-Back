package com.loicmaria.api.DTO;

import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
public class UserDto {

    private int id;

    private String username;

    private String mail;

    private String password;

    private List<RoleDto> roleList;

    private Collection<BookingDto> bookingDtoCollection;
}
