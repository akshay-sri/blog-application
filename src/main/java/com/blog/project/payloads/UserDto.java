package com.blog.project.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int userId;
    @NotEmpty
    @Size(min = 4, message = "Name should be min of 4 characters")
    private String userName;
    @Email(message = "Invalid Email!")
    private String email;
    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min. of 3 characters and max. of 10")
    private String password;
    @NotEmpty
    private String about;
    private Set<RoleDto> roles = new HashSet<>();
}
