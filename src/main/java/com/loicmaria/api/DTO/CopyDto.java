package com.loicmaria.api.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CopyDto {

    private int id;

    private String publisherName;

    private Date publicationDate;
}
