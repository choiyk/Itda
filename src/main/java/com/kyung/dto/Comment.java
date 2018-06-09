package com.kyung.dto;

import java.util.Date;

public class Comment {
	int id;
	int writer;
	int article; // f.k
	String content;
	Date date;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getWriter() 
	{
		return writer;
	}
	public void setWriter(int writer) 
	{
		this.writer = writer;
	}
	public int getArticle() 
	{
		return article;
	}
	public void setArticle(int article) 
	{
		this.article = article;
	}
	public String getContent() 
	{
		return content;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}
	public Date getDate() 
	{
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}	
}
