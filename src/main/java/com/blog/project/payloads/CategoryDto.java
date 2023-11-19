package com.blog.project.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private int catId;
    @NotBlank
    @Size(min = 4, message = "Title should be min. of 4 characters")
    private String catTitle;
    @NotBlank
    @Size(min = 10, message = "Description should be minimum of 10 characters")
    private String catDesc;
}
