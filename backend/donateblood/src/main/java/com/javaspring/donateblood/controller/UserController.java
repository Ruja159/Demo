package com.javaspring.donateblood.controller;

import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.model.dto.UserDto;
import com.javaspring.donateblood.service.UserService;
//import com.javaspring.donateblood.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping("/123")
    @GetMapping
    public String hello(){
        return "Hello WOrld";
    }

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody final UserDto userDto){

        User user = userService.addUser(User.from(userDto));
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<User> users = userService.getUsers();
        List<UserDto> userDto = users.stream().map(UserDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable final Long id){

        User user = userService.getUserById(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable final Long id){
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<UserDto> editUser(@PathVariable final Long id,
                                            @RequestBody final UserDto userDto){
        User editedUser = userService.editUser(id,User.from(userDto));
        return new ResponseEntity<>(UserDto.from(editedUser), HttpStatus.OK);

    }
}
