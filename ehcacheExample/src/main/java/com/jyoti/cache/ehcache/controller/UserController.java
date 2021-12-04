package com.jyoti.cache.ehcache.controller;

import com.jyoti.cache.ehcache.dto.Users;
import com.jyoti.cache.ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value= "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/search/{id}")
    public Users getUser(@PathVariable Long id){
        return userService.getUser(id);
    };

    @PostMapping("/create")
    public Users saveUser(@RequestBody Users users){
        return userService.saveUser(users);
    }
}
