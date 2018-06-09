package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.MeetingMember;

@Mapper
public interface MeetingMemberMapper {
	List<MeetingMember> findAll(); // 전체 모임, 모임에 속한 회원 조회 
	List<MeetingMember> findUsersByMeeting(int meetingId); // 모임 별 회원 조회 
	void update(MeetingMember meetingMember);
	void delete(int meetingId, int memberId);
}
