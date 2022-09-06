package com.javaproject.blog.services;

import com.javaproject.blog.payloads.CommentDto;


public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);
	

}
