package com.loicmaria.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public class Services<T, S extends JpaRepository<T, Integer>> {

    @Autowired
    public S repository;


    public Collection<T> getter() {
        return repository.findAll();
    }


    public Optional<T> get(int id) {
        return repository.findById(id);
    }


    public T save(T val) {
        T val2 = repository.save(val);
        return val2;
    }


    public void delete(int id) {
        repository.deleteById(id);
    }


    // Getters and Setters
    public S getRepository() {
        return repository;
    }
    public void setRepository(S repository) {
        this.repository = repository;
    }
}
