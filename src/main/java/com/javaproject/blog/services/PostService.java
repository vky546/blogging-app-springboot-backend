package com.javaproject.blog.services;

import java.util.List;

import com.javaproject.blog.entities.Post;
import com.javaproject.blog.payloads.PostDto;
import com.javaproject.blog.payloads.PostResponse;

public interface PostService {
	
	//Create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	 PostResponse getAllPost( Integer pageNumber, Integer pageSize, String sortBy, String sortDirection );
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all pot by category
	
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all post by user
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	
	List<PostDto> searchPosts(String keyword);
}
