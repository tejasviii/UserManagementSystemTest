package com.example.UserManagementSystem.Controller;

import com.example.UserManagementSystem.Model.User;
import com.example.UserManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user/management/system")
public class UserController {
//    Task: Create a basic user management system.
//
//    Requirements:
//
//    The API should support CRUD operations (Create, Read, Update, Delete) for users.
//    Each user should have a unique identifier, a name, an email address, and a password.
//    The API should store user information in a database.



    @Autowired
    private UserService userService;

    @GetMapping(value = "/all/users")
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/id/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/add/user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping(value = "/update/id/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping(value = "/delete/id/{id}")
    public String deleteUserById(@PathVariable Integer id){
        return userService.deleteUserById(id);
    }

    @DeleteMapping(value = "/all/users")
    public String deleteAllUsers(){
        return userService.deleteAllUsers();
    }
}
