package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int id;
	int writer;
	int article; // f.k
	String content;
	Date date;
	
	String wNickname; // writer nickname
	
	public String getwNickname() 
	{
		return wNickname;
	}
	
	public void setwNickname(String wNickname) 
	{
		this.wNickname = wNickname;
	}
	
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
	public String getDate() 
	{
		return sim.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}	
}
