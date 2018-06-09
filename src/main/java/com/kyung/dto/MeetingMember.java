package com.kyung.dto;

public class MeetingMember {
	int id;
	int meetingId; // f.k
	int memberId; // f.k
	String userName;
	String userStudentNumber;
	String userNickname;
	int userDepartmentId;
	int userGender;
	
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
