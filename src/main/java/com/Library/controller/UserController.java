package com.Library.controller;

import com.Library.model.User;
import com.Library.service.UserService;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(@PathParam("filter") String filter,
                                  @PathParam("notFilter") String notFilter){
        List<User> users = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)){
            users = userService.findByNameContains(filter);
        }
        else if(StringUtils.isNotBlank(notFilter)){
            users = userService.findByNameNotContains(notFilter);
        }
        else{
            users = userService.findAll();
        }
        log.debug("In the getUsers Users method");
        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        log.debug("In the getUser Users method: " + id);
        return userService.findById(id);
    }

    @GetMapping("/user/search")
    public List<User>searchByName(@PathParam("name") String name) {
        return userService.searchByName(name);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user){
        userService.delete(user);
    }

}
