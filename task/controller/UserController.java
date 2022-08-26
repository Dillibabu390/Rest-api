package com.students.task.controller;


import com.students.task.entity.User;
import com.students.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUser(){
        return userService.getUser();
    }
    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }
   /* @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        User user =userService.findById(id);
        return user;
    }*/

    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUserId(@PathVariable Integer id){
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User>updateUser(@PathVariable Integer id,@RequestBody User user){
        userService.updateUser(id, user);
        return new ResponseEntity<>(userService.findById(id),HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
