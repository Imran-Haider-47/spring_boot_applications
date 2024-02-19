package com.imhaider.springbootmysql.controller;

import com.imhaider.springbootmysql.dto.user.UserDTO;
import com.imhaider.springbootmysql.entity.User;
import com.imhaider.springbootmysql.services.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<User> users =  userService.getUsers();
        return ResponseEntity.ok(UserDTO.of(users));
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable final Integer id){
        return userService.getUser(id);
    }

    @PostMapping()
    public UserDTO insert(@RequestBody final User user){
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable final Integer id, @RequestBody final User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable final Integer id){
        return userService.deleteUser(id);
    }



}
