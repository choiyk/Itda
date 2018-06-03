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
	
	public User login(String loginId, String password) {
		User user = userMapper.findByStudentNumber(loginId);
		if(user == null) return null;
		String pw = Encryption.encrypt(password, Encryption.SHA256);
		if(user.getPassword().equals(pw) == false) return null;
		return user;
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
