package com.example.firstapirest.controller;


import com.example.firstapirest.entity.User;
import com.example.firstapirest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping({"/users","/"})
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping()
    public ArrayList<User> getUser(){
        return userService.getAll();
    }

    @PostMapping()
    public User saveUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<User> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<User> getUserByPriority(@RequestParam("priority") Integer prioridad){
        return this.userService.getByPriority(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "This user is delete " + id;
        }else{
            return "I cant delete this" + id;
        }
    }

}
