package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd");
	
	int id;
	String name;
	String explain;
	Date date;
	//int leader; // f.k
	
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
	public String getExplain() 
	{
		return explain;
	}
	public void setExplain(String explain) 
	{
		this.explain = explain;
	}
	
}
