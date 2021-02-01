package com.javaspring.donateblood.controller;

import com.javaspring.donateblood.model.User;
import com.javaspring.donateblood.model.dto.UserDto;
import com.javaspring.donateblood.service.UserService;
//import com.javaspring.donateblood.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@Api( tags = "Users")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "This method is used to add one user in database")
    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody final UserDto userDto){
        User checkUser = userService.getUserByUserName(userDto.getUserName());
        if (checkUser != null) {

            return new ResponseEntity<Object>("User_already_Exists", HttpStatus.OK);
        }
        User user = userService.addUser(User.from(userDto));
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);

    }

    @ApiOperation(value = "This method is used to get all users")
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<User> users = userService.getUsers();
        List<UserDto> userDto = users.stream().map(UserDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<UserDto> getUser(@PathVariable final Long id){
//
//        User user = userService.getUserById(id);
//        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
//    }
@ApiOperation(value = "This methos is used to delete user from the database")
    @DeleteMapping(value = "{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable final Long id){
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }
    @ApiOperation(value = "This methos is used to update users information")
    @PutMapping(value = "{id}")
    public ResponseEntity<UserDto> editUser(@PathVariable final Long id,
                                            @RequestBody final UserDto userDto){
        User editedUser = userService.editUser(id,User.from(userDto));
        return new ResponseEntity<>(UserDto.from(editedUser), HttpStatus.OK);

    }
    @ApiOperation(value = "This methos is used to get user by Username")
    @GetMapping(value = "{userName}")
    public ResponseEntity<UserDto> getUser(@PathVariable final String userName){

        User user = userService.getUserByUserName(userName);
        return new ResponseEntity<>(UserDto.from(user), HttpStatus.OK);
    }
}
