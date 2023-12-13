package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.UserDto;
import com.loicmaria.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //      CRUD Operations
    //----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.save(userDto);

        if (createdUser != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la création de l'utilisateur'.");
        }
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable int id) {
        return userService.get(id);
    }

    @GetMapping
    public Collection<UserDto> getUsers() {
        return userService.getter();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable int id,
            @RequestBody UserDto userDto) {

        if (id != userDto.getId()) {
            return ResponseEntity.badRequest().build();
        }

        userService.update(userDto);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean userExists = userService.exists(id);

        if (userExists){
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //------------------------------------------------------------------------------------------------------------------


    @GetMapping("/username/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        System.out.println("Username : " + username);
        return userService.findByUsername(username);
    }

}
