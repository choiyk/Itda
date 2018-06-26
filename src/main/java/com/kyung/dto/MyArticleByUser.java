package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyArticleByUser 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int articleId; // a
	int boardId; // a,b
	int writer; // a
	String title; // a
	String content; // a
	Date articleDate; // a
	int notice; // a
	int category; // a
	
	int meetingId; // b
	String name; // b
	
	int cateId; // c
	String cateName; // c
	
	public int getCateId() 
	{
		return cateId;
	}

	public void setCateId(int cateId) 
	{
		this.cateId = cateId;
	}

	public String getCateName() 
	{
		return cateName;
	}

	public void setCateName(String cateName) 
	{
		this.cateName = cateName;
	}

	public int getArticleId() 
	{
		return articleId;
	}
	
	public void setArticleId(int articleId) 
	{
		this.articleId = articleId;
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
	
	public String getArticleDate() 
	{
		return sim.format(articleDate);
	}
	
	public void setArticleDate(Date articleDate) 
	{
		this.articleDate = articleDate;
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
	
	public int getMeetingId() 
	{
		return meetingId;
	}
	
	public void setMeetingId(int meetingId) 
	{
		this.meetingId = meetingId;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
}
