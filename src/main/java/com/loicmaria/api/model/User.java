package com.loicmaria.api.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String mail;

    private String password;

    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "user")
    private Collection<Loan> loans;


}