package com.loicmaria.api.model;


import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "copies")
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int copies;

    private String language;

    private String publisherName;

    private Date publicationDate;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null) createDate = LocalDateTime.now();
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @ManyToOne
    private Book book;
    @OneToOne
    private Type type;

}
