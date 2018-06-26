package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.kyung.model.MeetingRegistrationModel;

public class Meeting {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd");
	
	int id;
	String name;
	String mexplain;
	Date date;
	//int leader; // f.k
	
	
	public MeetingRegistrationModel toRegistrationMeeting()
	{
		MeetingRegistrationModel model = new MeetingRegistrationModel();
		model.setMeetingName(this.getName());
		model.setMexplain(this.getMexplain());
		return model;
	}
	
	public String getDate() 
	{
		return sim.format(date);
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
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
