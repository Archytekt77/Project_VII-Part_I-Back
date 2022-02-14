package com.loicmaria.api.DTO;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDto {

        private int id;

        private String status;

        private Boolean extraTime;

        private LocalDateTime createDate;

        private LocalDateTime updateDate;

        private BookDto book;

        private UserDto user;
}
