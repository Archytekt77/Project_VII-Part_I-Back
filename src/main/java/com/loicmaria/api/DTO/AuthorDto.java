package com.loicmaria.api.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
public class AuthorDto {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private Collection<BookDto> bookCollection;

}
