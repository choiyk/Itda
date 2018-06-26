package com.kyung.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.kyung.dto.Comment;

public class CommentRegistrationModel 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	String userName;
	Date date;
	@Size(min=1, message="공백은 입력할 수 없습니다.")
	String content;
	
	List<Comment> comments;
	
	public List<Comment> getComments() 
	{
		return comments;
	}

	public void setComments(List<Comment> comments) 
	{
		this.comments = comments;
	}

	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getDate() 
	{
		return sim.format(date);
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}

	
}
