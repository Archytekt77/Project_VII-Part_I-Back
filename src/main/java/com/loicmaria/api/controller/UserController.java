package com.loicmaria.api.controller;


import com.loicmaria.api.DTO.UserDto;
import com.loicmaria.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    /**
     * Create - Add a new user
     *
     * @param userDto An object user
     * @return The user object saved
     */
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userServiceImpl.save(userDto);
    }


    /**
     * Read - Get one user
     *
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        UserDto userDto = userServiceImpl.get(id);
            return userDto;
    }

    /**
     * Read - Get all users
     *
     * @return - An Iterable object of User full filled
     */
    @GetMapping
    public Collection<UserDto> getUsers() {
        return userServiceImpl.getter();
    }

    /**
     * Update - Update an existing user
     *
     * @param id   - The id of the user to update
     * @param userDto - The user object updated
     * @return The currentUser if he is present or null
     */
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") int id, @RequestBody UserDto userDto) {
        userServiceImpl.save(userDto);
        return userDto;
    }


    /**
     * Delete - Delete an user
     *
     * @param id - The id of the user to delete
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userServiceImpl.delete(id);
    }
}
