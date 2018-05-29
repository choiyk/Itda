package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.mapper.UserMapper;
import com.kyung.dto.User;

@Service
public class UserService {
	@Autowired UserMapper userMapper;
	
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
