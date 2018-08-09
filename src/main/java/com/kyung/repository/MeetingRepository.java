package com.kyung.repository;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.socket.WebSocketSession;

import com.kyung.dto.Meeting;
import com.kyung.mapper.MeetingMapper;

@Repository
public class MeetingRepository {

	MeetingMapper meetingMapper;

	private final Map<Integer, Meeting> meetingMap;

	@Autowired
	public MeetingRepository(MeetingMapper meetingMapper){
		this.meetingMapper = meetingMapper;

		meetingMap = new HashMap<Integer, Meeting>();
		List<Meeting> meetings = meetingMapper.findAll();
		for(Meeting meeting : meetings){
			meetingMap.put(meeting.getId(), meeting);
		}

		Collection<Meeting> meetingMap = getMeetings();
		for(Meeting m : meetingMap){
			System.out.print(m.getName()+" ");
		}

	}

	public Meeting getMeeting(int id){
		return meetingMap.get(id);
	}

	public Collection<Meeting> getMeetings(){
		return meetingMap.values();
	}

	public void addMeeting(Meeting meeting){
		meetingMap.put(meeting.getId(), meeting);
	}

	public void removeMeeting(int id){
		if(meetingMap.get(id) != null)
			meetingMap.remove(id);
	}

	public void remove(WebSocketSession session) throws IOException{
		Collection<Meeting> meetings = getMeetings();
		for(Meeting meeting : meetings){
			Set<WebSocketSession> sessions = meeting.getSessions();
			sessions.remove(session);
		}
		session.close();
	}

}
