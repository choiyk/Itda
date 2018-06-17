package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int id;
	int boardId; // f.k
	int writer; // f.k
	String title;
	String content;
	Date date;
	int notice;
	int category; // f.k
	
	String userName; // u
	
	String cateName; // c
	
	public String getCateName() 
	{
		return cateName;
	}
	
	public void setCateName(String cateName) 
	{
		this.cateName = cateName;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getBoardId() 
	{
		return boardId;
	}
	public void setBoardId(int boardId) 
	{
		this.boardId = boardId;
	}
	public int getWriter() 
	{
		return writer;
	}
	public void setWriter(int writer) 
	{
		this.writer = writer;
	}
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}
	public String getContent() 
	{
		return content;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}
	public String getDate() 
	{
		return sim.format(date);
	}
	public void setDate(Date date) 
	{
		this.date = date;
	}
	public int getNotice() 
	{
		return notice;
	}
	public void setNotice(int notice) 
	{
		this.notice = notice;
	}
	public int getCategory() 
	{
		return category;
	}
	public void setCategory(int category) 
	{
		this.category = category;
	}
}
