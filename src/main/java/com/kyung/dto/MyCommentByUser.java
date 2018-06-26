package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCommentByUser 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int cmId; // c
	int writer; // c
	int articleId; // c
	String content; // s
	Date commentDate; // c
	
	int boardId; // a
	String title; // a
	String atContent; // a
	Date articleDate; // a
	int notice; // a
	
	int cateId; // c
	String cateName; //c
	
	int meetingId; // b
	
	String meetingName; // m
	String mexplain; // m
	Date meetingDate; // m
	
	public int getCmId() 
	{
		return cmId;
	}
	
	public void setCmId(int cmId) 
	{
		this.cmId = cmId;
	}
	
	public int getWriter() 
	{
		return writer;
	}
	
	public void setWriter(int writer) 
	{
		this.writer = writer;
	}
	
	public int getArticleId() 
	{
		return articleId;
	}
	
	public void setArticleId(int articleId) 
	{
		this.articleId = articleId;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	public String getCommentDate() 
	{
		return sim.format(commentDate);
	}
	
	public void setCommentDate(Date commentDate) 
	{
		this.commentDate = commentDate;
	}
	
	public int getBoardId() 
	{
		return boardId;
	}
	
	public void setBoardId(int boardId) 
	{
		this.boardId = boardId;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	public String getAtContent() 
	{
		return atContent;
	}
	
	public void setAtContent(String atContent) 
	{
		this.atContent = atContent;
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
	
	public int getMeetingId() 
	{
		return meetingId;
	}
	
	public void setMeetingId(int meetingId) 
	{
		this.meetingId = meetingId;
	}
	
	public String getMeetingName() 
	{
		return meetingName;
	}
	
	public void setMeetingName(String meetingName) 
	{
		this.meetingName = meetingName;
	}
	
	public String getMexplain() 
	{
		return mexplain;
	}
	
	public void setMexplain(String mexplain) 
	{
		this.mexplain = mexplain;
	}
	
	public String getMeetingDate() 
	{
		return sim.format(meetingDate);
	}
	
	public void setMeetingDate(Date meetingDate) 
	{
		this.meetingDate = meetingDate;
	}

}
