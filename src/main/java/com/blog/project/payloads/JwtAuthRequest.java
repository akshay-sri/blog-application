package com.blog.project.payloads;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthRequest {
    @Schema(example = "akshay@gmail.com")
    private String username;
    @Schema(example = "akshay123")
    private String password;
}
