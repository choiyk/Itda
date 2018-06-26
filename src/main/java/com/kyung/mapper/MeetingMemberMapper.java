package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.MeetingMember;
import com.kyung.dto.MeetingMember2;

@Mapper
public interface MeetingMemberMapper {
	List<MeetingMember> findAll(); // 전체 모임, 모임에 속한 회원 조회
	List<MeetingMember> findUsersByMeeting(int meetingId); // 모임 별 회원 조회
	List<MeetingMember2> findMeetingMemberByMeetingId(int meetingId);
	void update(MeetingMember meetingMember);
	void delete(int meetingId, int memberId);
	void insert(MeetingMember meetingMember);
	void delete2(int meetingMemberId);
}
