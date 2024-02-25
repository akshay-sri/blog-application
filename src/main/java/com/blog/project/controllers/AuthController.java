package com.blog.project.controllers;

import com.blog.project.exceptions.ApiException;
import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.JwtAuthRequest;
import com.blog.project.payloads.JwtAuthResponse;
import com.blog.project.payloads.UserDto;
import com.blog.project.security.JwtTokenHelper;
import com.blog.project.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authorization")
public class AuthController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(
            @RequestBody JwtAuthRequest request
    ) {
        this.authenticate(request.getUsername(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Details!");
            throw new ApiException("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(
            @RequestBody UserDto userDto
    ) {
        ApiResponse apiResponse = this.userService.registerUser(userDto);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
    }
}
