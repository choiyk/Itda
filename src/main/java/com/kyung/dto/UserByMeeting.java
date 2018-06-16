package com.kyung.dto;

public class UserByMeeting 
{
	int meetingId; //mm
	
	String studentNumber;// u
	String userName; //u
	String userNickName; //u
	
	int type; // mm
	
	public UserByMeeting()
	{
		meetingId = -1;
	}

	public int getMeetingId() 
	{
		return meetingId;
	}

	public void setMeetingId(int meetingId) 
	{
		this.meetingId = meetingId;
	}

	public String getStudentNumber() 
	{
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) 
	{
		this.studentNumber = studentNumber;
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

	public int getType() 
	{
		return type;
	}

	public void setType(int type) 
	{
		this.type = type;
	}
	
	
}
