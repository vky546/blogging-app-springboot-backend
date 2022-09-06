package com.javaproject.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproject.blog.entities.Category;
import com.javaproject.blog.exceptions.ResourceNotFoundException;
import com.javaproject.blog.payloads.CategoryDto;
import com.javaproject.blog.repositories.CategoryRepo;
import com.javaproject.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat  = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat =  this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category id", categoryId));
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		
		Category updatedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat =  this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category id", categoryId));
		this.categoryRepo.deleteById(categoryId);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat =  this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
		
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories =  this.categoryRepo.findAll();
		List<CategoryDto> catDtos =   categories.stream().map((cat)->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
		
		
		
		
	}

}
