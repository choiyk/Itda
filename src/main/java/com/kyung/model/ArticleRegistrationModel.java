package com.kyung.model;

import javax.validation.constraints.NotEmpty;

public class ArticleRegistrationModel {
	
	@NotEmpty
	String title;
	
	String contents;

	int category;
	
	public int getCategory() 
	{
		return category;
	}

	public void setCategory(int category) 
	{
		this.category = category;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getContents() 
	{
		return contents;
	}

	public void setContents(String contents) 
	{
		this.contents = contents;
	}
	
	
}
