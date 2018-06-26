package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Meeting;
import com.kyung.dto.MeetingMember;
import com.kyung.dto.MeetingMember2;
import com.kyung.dto.User;
import com.kyung.mapper.MeetingMemberMapper;

@Service
public class MeetingMemberService
{
	@Autowired MeetingMemberMapper meetingMemberMapper;

	//@SuppressWarnings("null")
	public void addInMeeting(Meeting meeting, User user, int userType)
	{
		MeetingMember member = new MeetingMember();
		member.setMeetingId(meeting.getId());
		member.setMemberId(user.getId());
		member.setType(userType); // 3: meeting manager, 2: meeting member
		meetingMemberMapper.insert(member);

		// test
		System.out.println("member id : "+member.getId());
		System.out.println("member meetingId : "+member.getMeetingId());
		System.out.println("member memberId : "+member.getMemberId());
		System.out.println("member memberType : "+member.getType());
	}

	public void addInMeeting(int meetingId, int userId, int userType)
	{
		MeetingMember member = new MeetingMember();
		member.setMeetingId(meetingId);
		member.setMemberId(userId);
		member.setType(userType); // 3: meeting manager, 2: meeting member
		meetingMemberMapper.insert(member);
	}

	public List<MeetingMember2> findMeetingMember(int meetingId){

		return meetingMemberMapper.findMeetingMemberByMeetingId(meetingId);

	}

	public void delete(int meetingMemberId){

		meetingMemberMapper.delete2(meetingMemberId);

	}
}
