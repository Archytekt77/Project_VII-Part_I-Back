package com.loicmaria.api.DTO;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String password;
}
