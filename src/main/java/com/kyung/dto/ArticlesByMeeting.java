package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticlesByMeeting 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int boardId; // b
	String boardName; // b
	
	int cateId;
	String cateName; // c
	
	int articleId;// a
	String articleTitle; // a
	
	String userName; // u
	String userNickName; // u
	
	Date articleDate; // a

	
	
	public int getArticleId() 
	{
		return articleId;
	}

	public void setArticleId(int articleId) 
	{
		this.articleId = articleId;
	}

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

	public String getArticleDate() 
	{
		return sim.format(articleDate);
	}

	public void setArticleDate(Date articleDate) 
	{
		this.articleDate = articleDate;
	}
}
