package com.javaproject.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.blog.entities.Comment;
import com.javaproject.blog.entities.Post;
import com.javaproject.blog.exceptions.ResourceNotFoundException;
import com.javaproject.blog.payloads.CommentDto;
import com.javaproject.blog.repositories.CommentRepo;
import com.javaproject.blog.repositories.PostRepo;
import com.javaproject.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post =  this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", postId));
		
		Comment comment =  this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedcomment  = this.commentRepo.save(comment);
		return this.modelMapper.map(savedcomment, CommentDto.class);
		
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "comment id", commentId));
		
		this.commentRepo.delete(comment);
		
		
	}

}
