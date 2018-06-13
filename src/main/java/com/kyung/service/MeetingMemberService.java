package com.kyung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Meeting;
import com.kyung.dto.MeetingMember;
import com.kyung.dto.User;
import com.kyung.mapper.MeetingMemberMapper;

@Service
public class MeetingMemberService 
{
	@Autowired MeetingMemberMapper meetingMemberMapper;
	
	//@SuppressWarnings("null")
	public void addInMeeting(Meeting meeting, User user)
	{
		MeetingMember member = new MeetingMember();
		member.setMeetingId(meeting.getId());
		member.setMemberId(user.getId());
		member.setType(3); // 3: meeting manager
		meetingMemberMapper.insert(member);
		
		// test
		System.out.println("member id : "+member.getId());
		System.out.println("member meetingId : "+member.getMeetingId());
		System.out.println("member memberId : "+member.getMemberId());
		System.out.println("member memberType : "+member.getType());
	}
}
