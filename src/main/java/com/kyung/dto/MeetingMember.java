package com.kyung.dto;

import java.util.Date;

public class MeetingMember {
	int id;
	int meetingId; // f.k
	int memberId; // f.k
	int type; // 2:user , 3:meeting manager
	Date date;
	
	String userName;
	String userStudentNumber;
	String userNickname;
	int userDepartmentId;
	int userGender;
	
	
	public Date getDate() 
	{
		return date;
	}

	public void setDate(Date date) 
	{
		this.date = date;
	}

	public int getType() 
	{
		return type;
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getMeetingId() 
	{
		return meetingId;
	}
	public void setMeetingId(int meetingId) 
	{
		this.meetingId = meetingId;
	}
	public int getMemberId() 
	{
		return memberId;
	}
	public void setMemberId(int memberId) 
	{
		this.memberId = memberId;
	}
}
