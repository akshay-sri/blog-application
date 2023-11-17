package com.blog.project.services;

import com.blog.project.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer userId,Integer postId);
    void deleteComment(Integer commentId);
}
