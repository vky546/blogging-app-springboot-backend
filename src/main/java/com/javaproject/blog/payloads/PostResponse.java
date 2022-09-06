package com.javaproject.blog.payloads;

import java.util.List;

import org.aspectj.util.IStructureModel;

public class PostResponse {
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalelements;
	private int totalPages;
	
	private boolean lastPage;

	public List<PostDto> getContent() {
		return content;
	}

	public void setContent(List<PostDto> content) {
		this.content = content;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalelements() {
		return totalelements;
	}

	public void setTotalelements(long totalelements) {
		this.totalelements = totalelements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
