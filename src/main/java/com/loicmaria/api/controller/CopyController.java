package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.CopyDto;
import com.loicmaria.api.service.CopyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/copies")
public class CopyController {
    
    @Autowired
    CopyServiceImpl copyService;


    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createCopy(@RequestBody CopyDto copyDto) {
        CopyDto createdCopy = copyService.save(copyDto);

        if (createdCopy != null){
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdCopy);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création de l'exemplaire.");
        }
    }

    @GetMapping("/{id}")
    public CopyDto getCopy(@PathVariable int id) {
        return copyService.get(id);
    }

    @GetMapping
    public Collection<CopyDto> getCopies() {
        return copyService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CopyDto> updateCopy(
            @PathVariable int id,
            @RequestBody CopyDto copyDto) {

        if (id != copyDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        copyService.save(copyDto);
        return ResponseEntity.ok(copyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCopy(@PathVariable int id) {
        boolean copyExists = copyService.exists(id);

        if (copyExists){
            copyService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //----------------------------------------------------------------------------------------------------------------

    @GetMapping("/book/{id}")
    public Collection<CopyDto> findByBook(@PathVariable int id){
        return copyService.findByBook_Id(id);
    }
}
