package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserJoinedMeetings 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd");
	
	int meetingId; // meeting
	String meetingName; // meeting
	String meetingExplain; // meeting
	Date meetingDate; // meeting
	
	String userName; // user
	
	int mmMeetingId; // meetingmember
	int mmMemberId; // meetingmember
	int mmType; // meetingmember
	Date mmDate; //meetingmember
	
	
	
	public String getMmDate() 
	{
		return sim.format(mmDate);
	}

	public void setMmDate(Date mmDate) 
	{
		this.mmDate = mmDate;
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
	
	public String getMeetingExplain() 
	{
		return meetingExplain;
	}
	
	public void setMeetingExplain(String meetingExplain) 
	{
		this.meetingExplain = meetingExplain;
	}
	
	public String getMeetingDate() 
	{
		return sim.format(meetingDate);
	}
	
	public void setMeetingDate(Date meetingDate) 
	{
		this.meetingDate = meetingDate;
	}
	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public int getMmMeetingId() 
	{
		return mmMeetingId;
	}
	
	public void setMmMeetingId(int mmMeetingId) 
	{
		this.mmMeetingId = mmMeetingId;
	}
	
	public int getMmMemberId() 
	{
		return mmMemberId;
	}
	
	public void setMmMemberId(int mmMemberId) 
	{
		this.mmMemberId = mmMemberId;
	}
	
	public int getMmType() 
	{
		return mmType;
	}
	
	public void setMmType(int mmType) 
	{
		this.mmType = mmType;
	}	
}
