package com.kyung.dto;

public class DepartmentByUser {

	int userId;
	String studentNumber;
	String name;
	String nickname;
	int question;
	String answer;
	int type;
	int gender;
	
	int departmentId;
	String departmentName;
	
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getStudentNumber() 
	{
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) 
	{
		this.studentNumber = studentNumber;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getNickname() 
	{
		return nickname;
	}
	public void setNickname(String nickname) 
	{
		this.nickname = nickname;
	}
	public int getQuestion() 
	{
		return question;
	}
	public void setQuestion(int question) 
	{
		this.question = question;
	}
	public String getAnswer() 
	{
		return answer;
	}
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	public int getType() 
	{
		return type;
	}
	public void setType(int type) 
	{
		this.type = type;
	}
	public int getGender() 
	{
		return gender;
	}
	public void setGender(int gender) 
	{
		this.gender = gender;
	}
	public int getDepartmentId() 
	{
		return departmentId;
	}
	public void setDepartmentId(int departmentId) 
	{
		this.departmentId = departmentId;
	}
	public String getDepartmentName() 
	{
		return departmentName;
	}
	public void setDepartmentName(String departmentName) 
	{
		this.departmentName = departmentName;
	}
	
	
}
