package com.blog.project.services;

import com.blog.project.payloads.ApiResponse;
import com.blog.project.payloads.UserDto;

import java.util.List;

public interface UserService {
    ApiResponse registerUser(UserDto user);

    ApiResponse createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}
