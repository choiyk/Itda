package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.mapper.UserMapper;
import com.kyung.utils.Encryption;
import com.kyung.dto.User;

@Service
public class UserService {
	@Autowired UserMapper userMapper;
	
	@SuppressWarnings("unused")
	public User login(String loginId, String password) {
		User user = userMapper.findByStudentNumber(loginId);
		System.out.println(user.getStudentNumber());
		
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
	
	public void join(User user) {
		String password = Encryption.encrypt(user.getPassword(), Encryption.SHA256);
		user.setPassword(password);
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
	
	public void create(User user) 
	{
		userMapper.insert(user);
	}
	
	public void delete(int id) 
	{
		userMapper.delete(id);
	}
	
	public void update(User user) {
		userMapper.update(user);
	}
	
}
