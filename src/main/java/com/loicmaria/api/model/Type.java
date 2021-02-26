package com.loicmaria.api.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

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
}
