package com.javaproject.blog.services;

import java.util.List;

import com.javaproject.blog.entities.Category;
import com.javaproject.blog.payloads.CategoryDto;

public interface CategoryService {
	// Create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// delete
	void deleteCategory(Integer categoryId);
	
	// get by Id
	CategoryDto getCategory(Integer categoryId);
	
	// get All
	List<CategoryDto> getAllCategories();

}
