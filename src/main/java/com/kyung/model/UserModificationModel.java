package com.kyung.model;

import javax.validation.constraints.NotEmpty;

import com.kyung.dto.User;

public class UserModificationModel 
{
	//@Size(min=2, max=20)
	//입력할 때만 출력되도록 
	@NotEmpty(message="닉네임을 입력하세요.")
	String nickname;
	
	Integer departmentId;
	String question;
	
	@NotEmpty
	String answer;
	
	public UserRegistrationModel toRegistrationUser(User user) 
	{
		UserRegistrationModel userModel = new UserRegistrationModel();
		userModel.setStudentNumber(user.getStudentNumber());
		userModel.setName(user.getName());
		userModel.setNickname(this.nickname);
		userModel.setGender(user.getGender());
		userModel.setDepartmentId(this.departmentId);
		userModel.setQuestion(this.question);
		userModel.setAnswer(this.answer);
		
		return userModel;
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
