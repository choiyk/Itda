package com.kyung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.kyung.dto.Meeting;

public class MeetingRegistrationModel 
{

	//@NotEmpty(message="내용을 입력하세요.")
	@Size(min=2, message="2자 이상 입력하세요.")
	String meetingName;
	
	//@NotEmpty(message="내용을 입력하세요.")
	//@Size(min=10, message="10자 이상 입력하세요.")
	String mexplain;


	public String getMeetingName() 
	{
		return meetingName;
	}

	public void setMeetingName(String meetingName) 
	{
		this.meetingName = meetingName;
	}

	public Meeting toMeeting()
	{
		Meeting meeting = new Meeting();
		meeting.setName(this.meetingName);
		meeting.setMexplain(this.mexplain); //
		System.out.println("toMeeting name:"+this.meetingName);
		System.out.println("toMeeting explain:"+this.mexplain);
		return meeting;
	}
	
	public String getMexplain() 
	{
		return mexplain;
	}

	public void setMexplain(String mexplain) 
	{
		this.mexplain = mexplain;
	}

}
