package com.blog.project.payloads;

import com.blog.project.entities.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private int postId;
    @NotBlank
    @Size(min = 4, message = "Title should be min. of 4 characters")
    private String postTitle;
    @NotBlank
    @Size(min = 10, message = "Description should be minimum of 10 characters")
    private String postDesc;
    private String postImg;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto>comments=new HashSet<>();
}
