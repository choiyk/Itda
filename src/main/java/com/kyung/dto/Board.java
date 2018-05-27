package com.kyung.dto;

public class Board {
	int id;
	int meetingId; // f.k
	String name;
	
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
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
}
