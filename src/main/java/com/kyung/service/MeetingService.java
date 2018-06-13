package com.kyung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Meeting;
import com.kyung.dto.User;
import com.kyung.mapper.MeetingMapper;
import com.kyung.mapper.MeetingMemberMapper;
import com.kyung.model.MeetingRegistrationModel;

@Service
public class MeetingService {
	@Autowired MeetingMapper meetingMapper;
	@Autowired MeetingMemberService meetingMemberService;
	@Autowired BoardService boardService;

	public void create(MeetingRegistrationModel meetingModel, User user) 
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
		boardService.addInMeeting(meeting);
		
	}
}
