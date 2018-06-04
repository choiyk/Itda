package com.kyung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.kyung.dto.User;

public class UserRegistrationModel {
	@NotEmpty
	@Size(min=9, max=10)
	String studentNumber;

	@NotEmpty
	@Size(min=8, max=15)
	String password1;
	String password2;
	
	@NotEmpty
	@Size(min=2, max=30)
	String name;
	
	@Size(min=2, max=30)
	String nickname;
	
	Integer departmentId;
	
	//@NotEmpty
	String question;
	
	//@NotEmpty
	String answer;
	
	@NotEmpty
	int gender;
	
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public User toUser() 
	{ //UserRegistrationModel to User Object
		User user = new User();
		return user;
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

	
	
	public String getPassword1() 
	{
		return password1;
	}

	public void setPassword1(String password1) 
	{
		this.password1 = password1;
	}

	public String getPassword2() 
	{
		return password2;
	}

	public void setPassword2(String password2) 
	{
		this.password2 = password2;
	}

	public Integer getDepartmentId() 
	{
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) 
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
	
}
