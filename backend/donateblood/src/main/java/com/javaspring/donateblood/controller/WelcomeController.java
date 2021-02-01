package com.javaspring.donateblood.controller;

import com.javaspring.donateblood.model.AuthRequest;
import com.javaspring.donateblood.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@Api( tags = "Authenticate")
@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @ApiOperation(value = "This metod generates a token ")
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception{

       try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        }
       catch (BadCredentialsException ex){
           throw new Exception("invalid username or pass", ex);
       }
      return  jwtUtil.generateToken(authRequest.getUserName());

    }
}
