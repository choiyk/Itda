package com.kyung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyung.dto.AlarmMessage;
import com.kyung.dto.Meeting;
import com.kyung.repository.MeetingRepository;

@Profile("!stomp")
@Component
public class AlarmHandler extends TextWebSocketHandler {

	private final ObjectMapper objectMapper;
	private final MeetingRepository meetingRepository;

	@Autowired
	public AlarmHandler(ObjectMapper objectMapper, MeetingRepository meetingRepository){
		this.objectMapper = objectMapper;
		this.meetingRepository = meetingRepository;
	}

	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String payload = message.getPayload();

        AlarmMessage alarmMessage = objectMapper.readValue(payload, AlarmMessage.class);

        System.out.println("alarmMessage.id: "+alarmMessage.getMeetingId());
        System.out.println("alarmMessage.name: "+alarmMessage.getMeetingName());
        System.out.println("alarmMessage.content: "+alarmMessage.getContent());
        System.out.println("alarmMessage.type: "+alarmMessage.getType());

        Meeting meeting = meetingRepository.getMeeting(alarmMessage.getMeetingId());
        meeting.handleMessage(session, alarmMessage, objectMapper);
	}

	@Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		meetingRepository.remove(session);
    }

}
