package com.loicmaria.api.controller;


import com.loicmaria.api.model.User;
import com.loicmaria.api.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserServiceImpl userService;

    /**
     * Create - Add a new user
     * @param user An object user
     * @return The user object saved
     */
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }


    /**
     * Read - Get one user 
     * @param id The id of the user
     * @return An User object full filled
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        Optional<User> user = userService.get(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get all users
     * @return - An Iterable object of User full filled
     */
    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getter();
    }

    /**
     * Update - Update an existing user
     * @param id - The id of the user to update
     * @param user - The user object updated
     * @return The currentUser if he is present or null
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> e = userService.get(id);
        if(e.isPresent()) {
            User currentUser = e.get();

            String firstName = user.getFirstName();
            if(firstName != null) {
                currentUser.setFirstName(firstName);
            }
            String lastName = user.getLastName();
            if(lastName != null) {
                currentUser.setLastName(lastName);
            }
            String mail = user.getMail();
            if(mail != null) {
                currentUser.setMail(mail);
            }
            String password = user.getPassword();
            if(password != null) {
                currentUser.setPassword(password);
            }
            userService.save(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }


    /**
     * Delete - Delete an user
     * @param id - The id of the user to delete
     */
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
