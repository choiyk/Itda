package com.kyung.dto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyung.model.MeetingRegistrationModel;

public class Meeting {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd");

	int id;
	String name;
	String mexplain;
	Date date;
	//int leader; // f.k
	private Set<WebSocketSession> sessions = new HashSet<>();

	//WebSocket
	public void handleMessage(WebSocketSession session, AlarmMessage alarmMessage, ObjectMapper objectMapper) throws JsonProcessingException{
		if(alarmMessage.getType().equals("JOIN")){
			join(session);
		}
		send(alarmMessage, objectMapper);
	}

	public void join(WebSocketSession session){
		sessions.add(session);
	}

	private <T> void send(T messageObject, ObjectMapper objectMapper) throws JsonProcessingException{
		TextMessage message = new TextMessage(objectMapper.writeValueAsString(messageObject));
        sessions.parallelStream().forEach(session -> {
			try {
				session.sendMessage(message);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

//	public static Meeting create()

	public MeetingRegistrationModel toRegistrationMeeting()
	{
		MeetingRegistrationModel model = new MeetingRegistrationModel();
		model.setMeetingName(this.getName());
		model.setMexplain(this.getMexplain());
		return model;
	}

	public String getDate()
	{
		return sim.format(date);
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getMexplain()
	{
		return mexplain;
	}
	public void setMexplain(String mexplain)
	{
		this.mexplain = mexplain;
	}
	public Set<WebSocketSession> getSessions() {
		return sessions;
	}
	public void setSessions(Set<WebSocketSession> sessions) {
		this.sessions = sessions;
	}

}
