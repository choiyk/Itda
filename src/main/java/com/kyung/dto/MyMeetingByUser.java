package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyMeetingByUser 
{
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd");
	
	int meetingId; // m
	String meetingName; // m
	String mexplain; // m
	Date meetingDate; // m
	
	int mmId; // mm
	int memberId; // mm
	int memberType; // mm
	Date memberDate; // mm
	
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
	
	public int getMmId() 
	{
		return mmId;
	}
	
	public void setMmId(int mmId) 
	{
		this.mmId = mmId;
	}
	
	public int getMemberId() 
	{
		return memberId;
	}
	
	public void setMemberId(int memberId) 
	{
		this.memberId = memberId;
	}
	
	public int getMemberType() 
	{
		return memberType;
	}
	
	public void setMemberType(int memberType) 
	{
		this.memberType = memberType;
	}
	
	public String getMemberDate() 
	{
		return sim.format(memberDate);
	}
	
	public void setMemberDate(Date memberDate) 
	{
		this.memberDate = memberDate;
	}
	
}
