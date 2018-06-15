package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.ArticlesByMeeting;
import com.kyung.dto.Board;
import com.kyung.dto.Category;
import com.kyung.dto.Meeting;
import com.kyung.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired BoardMapper boardMapper;
	
	public List<ArticlesByMeeting> articlesByMeeting(int meetingId)
	{
		List<ArticlesByMeeting> articles = boardMapper.articlesByMeeting(meetingId);
		return articles;
	}
	
	public Category boardCategory(int meetingId)
	{
		Category category = new Category();
		category = boardMapper.boardCategory(meetingId);
		return category;
	}
	
	public void addInMeeting(Meeting meeting)
	{
		Board board = new Board();
		board.setMeetingId(meeting.getId());
		board.setName(meeting.getName());
		boardMapper.insert(board); //
		
		//test
		System.out.println("board id : "+board.getId());
		System.out.println("board meetingId : "+board.getMeetingId());
		System.out.println("board name : "+board.getName());
	}
}
