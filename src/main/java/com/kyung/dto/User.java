package com.kyung.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	int id;
	
	//@NotEmpty
	//@Size(min=9, max=10)
	String studentNumber;
	
	//@NotEmpty
	//@Size(min=2)
	String name;
	
	char firstChar;
	
	String nickname;
	
	//@NotEmpty
	//@Size(min=8)
	String password;
	
	int departmentId; // f.k
	String question;
	String answer;
	
	//@NotEmpty
	int type; // 1: admin, 2:user
	
	//@NotEmpty
	int gender; 
	
	
	public int getGender() 
	{
		return gender;
	}
	public void setGender(int gender) 
	{
		this.gender = gender;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
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
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public int getDepartmentId() 
	{
		return departmentId;
	}
	public void setDepartmentId(int departmentId) 
	{
		this.departmentId = departmentId;
	}
	public String getQuestion() 
	{
		return question;
	}
	public void setQuestion(String question) 
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
	
	public char getFirstChar() 
	{
		this.firstChar = this.name.charAt(0);
		return firstChar;
	}
	public void setFirstChar(char firstChar) 
	{
		this.firstChar = firstChar;
	}
}
