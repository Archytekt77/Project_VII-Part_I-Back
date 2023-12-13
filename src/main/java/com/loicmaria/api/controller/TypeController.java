package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.TypeDto;
import com.loicmaria.api.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeServiceImpl typeService;


    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createType(@RequestBody TypeDto typeDto) {
        TypeDto createdType = typeService.save(typeDto);

        if (createdType != null){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdType);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du genre.");
        }
    }

    @GetMapping("/{id}")
    public TypeDto getType(@PathVariable int id) {
        return typeService.get(id);
    }

    @GetMapping
    public Collection<TypeDto> getTypes() {
        return typeService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDto> updateType(
            @PathVariable int id,
            @RequestBody TypeDto typeDto) {

        if (id != typeDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        typeService.save(typeDto);
        return ResponseEntity.ok(typeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable int id) {
        boolean typeExists = typeService.exists(id);

        if (typeExists){
            typeService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
