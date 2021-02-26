package com.loicmaria.api.controller;


import com.loicmaria.api.model.Type;
import com.loicmaria.api.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/type")
public class TypeController {
    
    @Autowired
    TypeServiceImpl typeService;

    /**
     * Create - Add a new type
     * @param type An object type
     * @return The type object saved
     */
    @PostMapping("/type")
    public Type createType(@RequestBody Type type) {
        return typeService.save(type);
    }


    /**
     * Read - Get one type 
     * @param id The id of the type
     * @return An Type object full filled
     */
    @GetMapping("/type/{id}")
    public Type getType(@PathVariable("id") int id) {
        Optional<Type> type = typeService.get(id);
        if(type.isPresent()) {
            return type.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all types
     * @return - An Iterable object of Type full filled
     */
    @GetMapping("/types")
    public Iterable<Type> getTypes() {
        return typeService.getter();
    }

    /**
     * Update - Update an existing type
     * @param id - The id of the type to update
     * @param type - The type object updated
     * @return The currentType if he is present or null
     */
    @PutMapping("/type/{id}")
    public Type updateType(@PathVariable("id") int id, @RequestBody Type type) {
        Optional<Type> e = typeService.get(id);
        if(e.isPresent()) {
            Type currentType = e.get();

            String name = type.getName();
            if(name != null) {
                currentType.setName(name);
            }
            typeService.save(currentType);
            return currentType;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an type
     * @param id - The id of the type to delete
     */
    @DeleteMapping("/type/{id}")
    public void deleteType(@PathVariable("id") int id) {
        typeService.delete(id);
    }
}
