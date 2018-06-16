package com.kyung.dto;

import java.util.Date;

public class ArticlesByMeeting 
{
	int boardId; // b
	String boardName; // b
	
	int cateId;
	String cateName; // c
	
	String articleTitle; // a
	
	String userName; // u
	String userNickName; // u
	
	Date articleDate; // a

	
	
	public int getCateId() 
	{
		return cateId;
	}

	public void setCateId(int cateId) 
	{
		this.cateId = cateId;
	}

	public int getBoardId() 
	{
		return boardId;
	}

	public void setBoardId(int boardId) 
	{
		this.boardId = boardId;
	}

	public String toString()
	{
		return "board:"+boardName+" category:"+cateName+"\n"+
				"article:"+articleTitle+" user"+userName+" date:"+articleDate;
	}
	
	public String getBoardName() 
	{
		return boardName;
	}

	public void setBoardName(String boardName) 
	{
		this.boardName = boardName;
	}

	public String getCateName() 
	{
		return cateName;
	}

	public void setCateName(String cateName) 
	{
		this.cateName = cateName;
	}

	public String getArticleTitle() 
	{
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) 
	{
		this.articleTitle = articleTitle;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserNickName() 
	{
		return userNickName;
	}

	public void setUserNickName(String userNickName) 
	{
		this.userNickName = userNickName;
	}

	public Date getArticleDate() 
	{
		return articleDate;
	}

	public void setArticleDate(Date articleDate) 
	{
		this.articleDate = articleDate;
	}
}
