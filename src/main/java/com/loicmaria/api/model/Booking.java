package com.loicmaria.api.model;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity(name = "Booking")
@Table(name = "Booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String status;
    @Column
    private Boolean extraTime;

    @PrePersist
    protected void prePersist() {
        if (this.createDate == null) {
            createDate = LocalDateTime.now();
            updateDate = null;
        }
    }

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column
    private LocalDateTime updateDate;

    @OneToOne
    private Book book;
    @ManyToOne
    private User user;
}
