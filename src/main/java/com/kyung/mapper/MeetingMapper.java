package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.Meeting;

@Mapper
public interface MeetingMapper {
	List<Meeting> findAll(); 
	Meeting findOne(int id);
	Meeting findByName(String name);
	Meeting findByLeader(int leader);
	void delete(int id);
	void insert(Meeting meeting);
	void update(Meeting meeting);
}
