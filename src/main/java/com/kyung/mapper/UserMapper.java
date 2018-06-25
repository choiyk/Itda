package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.dto.Meeting;
import com.kyung.dto.MyMeetingByUser;
import com.kyung.dto.User;
import com.kyung.dto.UserJoinedMeetings;

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
	void pwUpdate(@Param("password") String password, @Param("studentNumber") String studentNumber);
	List<UserJoinedMeetings> userJoinMeetings(int id);
	List<MyMeetingByUser> myMeetingByUser(int userId);
}
