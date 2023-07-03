package com.loicmaria.api.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanDto {

    private int id;

    private String status;

    private boolean extraTime;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private CopyDto copyDto;

    private UserDto user;
}
