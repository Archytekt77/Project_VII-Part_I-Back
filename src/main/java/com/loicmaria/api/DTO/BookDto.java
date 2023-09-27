package com.loicmaria.api.DTO;



import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Data
public class BookDto {

    private int id;

    private String title;

    private String summary;

    private Date publicationDate;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private AuthorDto author;

    private Collection<CopyDto> copyCollection;
}
