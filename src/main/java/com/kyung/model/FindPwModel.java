package com.kyung.model;

import javax.validation.constraints.NotEmpty;

public class FindPwModel {

	@NotEmpty
	String studentNumber;

	int question;

	@NotEmpty
	String answer;

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
