package com.kyung.model;

import javax.validation.constraints.NotEmpty;

import com.kyung.dto.User;

public class UserModificationModel 
{
	String studentNumber;
	String name;
	
	//@Size(min=2, max=20)
	//입력할 때만 출력되도록 
	@NotEmpty(message="닉네임을 입력하세요.")
	String nickname;
	
	Integer departmentId;
	String question;
	
	@NotEmpty
	String answer;
	
	Integer gender;
	
	public UserModificationModel inputUser(User user) 
	{
		UserModificationModel userModel = new UserModificationModel();
		userModel.setStudentNumber(user.getStudentNumber());
		userModel.setName(user.getName());
		//System.out.println("nickname:"+model.getNickname());
		userModel.setNickname(user.getNickname());
		userModel.setGender(user.getGender());
		userModel.setDepartmentId(user.getDepartmentId());
		userModel.setQuestion(user.getQuestion());
		userModel.setAnswer(user.getAnswer());
		return userModel;
	}
	
	public User toUser(User inputUser)
	{
		User user = new User();
		user.setStudentNumber(this.studentNumber);
		user.setPassword(inputUser.getPassword());
		user.setName(this.name);
		user.setNickname(this.nickname);
		user.setGender(inputUser.getGender());
		user.setDepartmentId(this.departmentId);
		user.setQuestion(this.question);
		user.setAnswer(this.answer);
		return user;
	}
	
	public UserRegistrationModel toRegistrationUser(User user) 
	{
		UserRegistrationModel userModel = new UserRegistrationModel();
		userModel.setStudentNumber(user.getStudentNumber());
		userModel.setName(user.getName());
		userModel.setNickname(user.getNickname());
		userModel.setGender(user.getGender());
		userModel.setDepartmentId(user.getDepartmentId());
		userModel.setQuestion(user.getQuestion());
		userModel.setAnswer(user.getAnswer());
		
		return userModel;
	}

	
	
	public Integer getGender() {
		return gender;
	}



	public void setGender(Integer gender) {
		this.gender = gender;
	}



	public String getStudentNumber() 
	{
		return studentNumber;
	}



	public void setStudentNumber(String studentNumber) 
	{
		this.studentNumber = studentNumber;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
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
