package com.kyung.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlarmMessage {

	private int meetingId;
	private String type;
	private String content;
	private String meetingName;

}
