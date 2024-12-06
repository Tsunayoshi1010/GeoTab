package com.GeoTab.GeoTab.Users.controller;

import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Users.services.imp.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.findIdUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            this.userService.deleteUser(id);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("User with ID " + id + " has been successfully deleted.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " not found.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while trying to delete the user: " + e.getMessage());
        }
    }

}
