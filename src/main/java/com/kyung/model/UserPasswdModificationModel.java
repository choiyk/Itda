package com.kyung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kyung.dto.User;

public class UserPasswdModificationModel {
	
	@NotEmpty
	@Size(min=8, max=15)
	@Pattern(regexp="^(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",
				message="하나 이상의 특수문자를 포함해야합니다.")
	String password1;
	
	@NotEmpty
	@Size(min=8, max=15)
	@Pattern(regexp="^(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$",
				message="하나 이상의 특수문자를 포함해야합니다.")
	String password2;

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
	
}
