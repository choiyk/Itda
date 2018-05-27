package com.kyung.dto;

public class MeetingMember {
	int id;
	int meetingId; // f.k
	int member; // f.k
	
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
	public int getMember() 
	{
		return member;
	}
	public void setMember(int member) 
	{
		this.member = member;
	}
}
