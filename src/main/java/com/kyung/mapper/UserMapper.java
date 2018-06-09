package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.User;

@Mapper
public interface UserMapper {
	User findOne(int id);
	User findByStudentNumber(String studentNumber);
	User findByDepartmentId(int departmentId); 
	User findByNickname(String nickname); 
	User findByName(String name); 
	List<User> findAll();
	void insert(User user);
	void update(User user);
	void delete(int id);
	void edit(User user);
}
