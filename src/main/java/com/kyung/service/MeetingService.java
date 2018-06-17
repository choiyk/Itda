package com.kyung.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Board;
import com.kyung.dto.Meeting;
import com.kyung.dto.User;
import com.kyung.dto.UserByMeeting;
import com.kyung.mapper.MeetingMapper;
import com.kyung.mapper.MeetingMemberMapper;
import com.kyung.model.MeetingRegistrationModel;

@Service
public class MeetingService {
	@Autowired MeetingMapper meetingMapper;
	@Autowired MeetingMemberService meetingMemberService;
	@Autowired BoardService boardService;

	public Board findBoardByMeeting(int meetingId)
	{
		Board board = new Board();
		board = meetingMapper.findBoardByMeeting(meetingId);
		return board;
	}
	
	public UserByMeeting findUserByMeeting(int meetingId, int userId)
	{
		UserByMeeting userByMeeting = meetingMapper.findUserByMeeting(meetingId, userId);
		Optional<UserByMeeting> result = Optional.ofNullable(userByMeeting);
		return result.orElse(new UserByMeeting());
	}
	
	/*
	public UserByMeeting findUserByMeeting(int meetingId, int userId)
	{
		UserByMeeting userByMeeting = new UserByMeeting();
		userByMeeting = meetingMapper.findUserByMeeting(meetingId, userId);
		return userByMeeting;
	}*/
	
	public Meeting findOne(int id)
	{
		Meeting meeting = new Meeting();;
		meeting = meetingMapper.findOne(id);
		return meeting;
	}
	
	public int create(MeetingRegistrationModel meetingModel, User user) 
	{
		// add meeting
		Meeting meeting = meetingModel.toMeeting();
		System.out.println("toMeeting 완");
		//meeting.setLeader(user.getId());
		meetingMapper.insert(meeting);//
		System.out.println("meetingMapper insert 완");
		
		// test
		System.out.println("meeting id : "+meeting.getId());
		System.out.println("meeting name : "+meeting.getName());
		System.out.println("meeting explain : "+meeting.getExplain());
		//System.out.println("meeting leader : "+meeting.getLeader());
		
		// add meetingMember
		meetingMemberService.addInMeeting(meeting, user);
		
		// add board
		int boardId;
		boardId = boardService.addInMeeting(meeting);
		
		// default category
		boardService.defaultCategory(boardId);
		
		return meeting.getId();
	}
}
