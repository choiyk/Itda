package com.kyung.dto;

public class Meeting {
	int id;
	String name;
	String explain;
	int leader; // f.k
	
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
	public int getLeader() 
	{
		return leader;
	}
	public void setLeader(int leader) 
	{
		this.leader = leader;
	}
	
}
