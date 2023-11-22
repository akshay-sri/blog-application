package com.blog.project.controllers;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.UserDto;
import com.blog.project.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "User")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable(name = "userId") Integer uId) {
        UserDto updateUserDto = this.userService.updateUser(userDto, uId);
        return ResponseEntity.ok(updateUserDto);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "userId") Integer uId) {
        return ResponseEntity.ok(this.userService.getUserById(uId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUser() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "userId") Integer uId) {
        this.userService.deleteUser(uId);
        return new ResponseEntity(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }
}
