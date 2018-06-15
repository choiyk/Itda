package com.kyung.service;

import java.util.Iterator;
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
	
	public List<ArticlesByMeeting> boardArticles(int meetingId)
	{
		List<ArticlesByMeeting> articles = boardMapper.boardArticles(meetingId);
/*
		for(ArticlesByMeeting article : articles)
		{
			System.out.println(article.getArticleTitle());
		}*/
		return articles;
	}
	
	public List<Category> boardCategory(int meetingId)
	{
		List<Category> category = boardMapper.boardCategory(meetingId);
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
