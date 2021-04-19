package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.TypeDto;
import com.loicmaria.api.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    TypeServiceImpl typeService;

    /**
     * Create - Add a new type
     *
     * @param typeDto An object type
     * @return The type object saved
     */
    @PostMapping
    public TypeDto createType(@RequestBody TypeDto typeDto) {
        return typeService.save(typeDto);
    }


    /**
     * Read - Get one type
     *
     * @param id The id of the type
     * @return An Type object full filled
     */
    @GetMapping("/{id}")
    public TypeDto getType(@PathVariable("id") int id) {
        TypeDto typeDto = typeService.get(id);
        return typeDto;
    }

    /**
     * Read - Get all types
     *
     * @return - An Iterable object of Type full filled
     */
    @GetMapping
    public Collection<TypeDto> getTypes() {
        return typeService.getter();
    }

    /**
     * Update - Update an existing type
     *
     * @param id   - The id of the type to update
     * @param typeDto - The type object updated
     * @return The currentType if he is present or null
     */
    @PutMapping("/{id}")
    public TypeDto updateType(@PathVariable("id") int id, @RequestBody TypeDto typeDto) {
        typeService.save(typeDto);
        return typeDto;
    }


    /**
     * Delete - Delete an type
     *
     * @param id - The id of the type to delete
     */
    @DeleteMapping("/{id}")
    public void deleteType(@PathVariable("id") int id) {
        typeService.delete(id);
    }
}
