package com.imhaider.springbootmysql.controller;

import com.imhaider.springbootmysql.entity.User;
import com.imhaider.springbootmysql.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable final Integer id){
        return userService.getUser(id);
    }

    @PostMapping()
    public User insert(@RequestBody final User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable final Integer id, @RequestBody final User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable final Integer id){
        return userService.deleteUser(id);
    }



}
