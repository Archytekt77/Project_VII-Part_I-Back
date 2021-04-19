package com.loicmaria.api.DTO;


import lombok.Data;

import java.util.Date;

@Data
public class BookDto {

    private int id;

    private String title;

    private String collection;

    private String summary;

    private String language;

    private Date publication;
}
