package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.CopyDto;
import com.loicmaria.api.service.CopyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/copies")
public class CopyController {
    
    @Autowired
    CopyServiceImpl copyServiceImpl;


    //      CRUD
    //----------------------------------------------------------------------------------------------------------------

    /**
     * Create - Add a new copy
     *
     * @param copyDto An object copy
     * @return ResponseEntity.ok
     */
    @PostMapping("/create")
    public ResponseEntity<?> createCopy(@RequestBody CopyDto copyDto) {
        return ResponseEntity.ok(copyServiceImpl.save(copyDto));
    }


    /**
     * Read - Get one copy
     *
     * @param id The id of the copy
     * @return An Copy object full filled
     */
    @GetMapping("/id/{id}")
    public CopyDto getCopy(@PathVariable("id") int id) {
        CopyDto copyDto = copyServiceImpl.get(id);
        return copyDto;
    }

    /**
     * Read - Get all copies
     *
     * @return - An Iterable object of Copy full filled
     */
    @GetMapping("/all")
    public Collection<CopyDto> getCopies() {
        return copyServiceImpl.getter();
    }

    /**
     * Update - Update an existing copy
     *
     * @param id     - The id of the copy to update
     * @param copyDto - The copy object updated
     * @return The currentCopy if he is present or null
     */
    @PutMapping("/id/{id}")
    public CopyDto updateCopy(@PathVariable("id") int id, @RequestBody CopyDto copyDto) {
        copyServiceImpl.save(copyDto);
        return copyDto;
    }


    /**
     * Delete - Delete an copy
     *
     * @param id - The id of the copy to delete
     */
    @DeleteMapping("/id/{id}")
    public void deleteCopy(@PathVariable("id") int id) {
        copyServiceImpl.delete(id);
    }

    //----------------------------------------------------------------------------------------------------------------

    /**
     * Read - Get the collection of copies linked to the book.
     *
     * @param id The id of a book.
     * @return The collection of copyDTO linked to the book.
     */
    @GetMapping("/book_id/{id}")
    public Collection<CopyDto> findByBook_Id(@PathVariable int id){
        Collection<CopyDto> copyDtoCollection = copyServiceImpl.findByBook_Id(id);
        return copyDtoCollection;
    }
}
