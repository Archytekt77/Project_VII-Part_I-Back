package com.loicmaria.api.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CopyDto {

    private int id;

    private int copies;

    private String publisherName;

    private Date publicationDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private BookDto book;

    private TypeDto type;
}
