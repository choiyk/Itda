package com.kyung.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.kyung.dto.Meeting;
import com.kyung.dto.User;
import com.kyung.mapper.UserMapper;
import com.kyung.model.UserRegistrationModel;
import com.kyung.utils.Encryption;

@Service
public class UserService {
	@Autowired UserMapper userMapper;
	
	public List<Meeting> userJoinMeetings(int userId)
	{
		List<Meeting> list=userMapper.userJoinMeetings(userId);
		//test
		//for(Meeting m : list) System.out.println(m.getName());
		return list;
	}

	public boolean passwordComparisonEdit(String pw1, String pw2, BindingResult bindingResult)
	{
		if(pw1.equals(pw2) == false)
		{
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}

	public boolean passwordComparison(String pw1, String pw2, BindingResult bindingResult)
	{
		if(pw1.equals(pw2) == false)
		{
			bindingResult.rejectValue("password", null, "비밀번호가 일치하지 않습니다.");
			return false;
		}

		return true;
	}

	public User getCurrentUser()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof UserAuthenticationProvider.UserAuthentication)
			return ((UserAuthenticationProvider.UserAuthentication)authentication).getUser();
		return null;
	}

	public static void setCurrentUser(User user)
	{
		((UserAuthenticationProvider.UserAuthentication)SecurityContextHolder.getContext()
				.getAuthentication()).setUser(user);
	}

	public boolean hasErrors(UserRegistrationModel userModel, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return true;
		}

		if(userModel.getPassword1().equals(userModel.getPassword2())==false)
		{
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return true;
		}

		User user = userMapper.findByStudentNumber(userModel.getStudentNumber());

		if(user != null)
		{
			bindingResult.rejectValue("studentNumber", null, "학번이 중복됩니다.");
			return true;
		}

		return false;
	}

	public User login(String loginId, String password) {
		User user = userMapper.findByStudentNumber(loginId);
		//System.out.println(user.getStudentNumber());

		if(user == null) {
			return null;
		}
		String pw = Encryption.encrypt(password, Encryption.SHA256);
		if(user.getPassword().equals(pw) == false)
		{
			System.out.println("불일치");
			return null;
		}
		System.out.println("일치");
		return user;
	}
	/*
	public void join(User user) {
		String password = Encryption.encrypt(user.getPassword(), Encryption.SHA256);
		user.setPassword(password);
		userMapper.insert(user);
	}*/

	public void join(UserRegistrationModel userModel) {
		User user = userModel.toUser();
		String password = Encryption.encrypt(user.getPassword(), Encryption.SHA256);

		user.setPassword(password);
		user.setType(2); // 2: user
		if(user.getNickname() == "")
			user.setNickname(user.getName());

		userMapper.insert(user);
	}

	public List<User> findAll()
	{
		List<User> users = userMapper.findAll();
		return users;
	}

	public User findOne(int id) {
		User user = userMapper.findOne(id);
		return user;
	}

	public User findByStudentNumber(String studentNumber)
	{
		User user = userMapper.findByStudentNumber(studentNumber);
		return user;
	}
	
	public User findByName(String name)
	{
		User user = userMapper.findByName(name);
		return user;
	}

	public void create(User user)
	{
		userMapper.insert(user);
	}

	public void delete(int id)
	{
		userMapper.delete(id);
	}

	public void update(User user)
	{
		userMapper.update(user);
	}

	public void edit(User user)
	{
		userMapper.edit(user);
	}

	public void pwUpdate(User user,String password)
	{
		System.out.println("pwUpdate:"+password);
		password = Encryption.encrypt(password, Encryption.SHA256);
		String studentNumber = user.getStudentNumber();
		System.out.println("pwUpdate:"+password+" "+studentNumber);
		userMapper.pwUpdate(password, studentNumber);
	}

}
