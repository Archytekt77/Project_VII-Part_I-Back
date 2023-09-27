package com.loicmaria.api.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingDto {

    private int id;

    private String status;

    private LocalDate startDate;

    private LocalDate endDate;

    private boolean extraTime;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private CopyDto copyDto;

    private UserDto user;
}
