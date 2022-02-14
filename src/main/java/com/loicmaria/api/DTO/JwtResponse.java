package com.loicmaria.api.DTO;

import com.loicmaria.api.model.User;
import lombok.Data;

@Data
public class JwtResponse {

    private final String jwtToken;

    private final User user;
}