package com.blog.project.controllers;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.UserDto;
import com.blog.project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable(name = "userId") Integer uId) {
        UserDto updateUserDto = this.userService.updateUser(userDto, uId);
        return ResponseEntity.ok(updateUserDto);
    }

    @GetMapping("getUser/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "userId") Integer uId) {
        return ResponseEntity.ok(this.userService.getUserById(uId));
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getUser() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(name = "userId") Integer uId) {
        this.userService.deleteUser(uId);
        return new ResponseEntity(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }
}
