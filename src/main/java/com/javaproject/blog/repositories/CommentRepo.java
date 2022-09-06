package com.javaproject.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer > {

}
