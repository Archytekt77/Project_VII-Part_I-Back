package com.loicmaria.api.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TypeDto {

    private int id;

    private String name;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}
