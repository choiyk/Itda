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
import com.kyung.model.ArticleRegistrationModel;

@Service
public class BoardService {

	public BoardService(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	BoardMapper boardMapper;
	
	public int findMeetingByBoard(int boardId)
	{
		Meeting meeting = boardMapper.findMeetingByBoard(boardId);
		int meetingId = meeting.getId();
		return meetingId;
	}
	
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
	
	public List<Category> boardCategoryByBoardId(int boardId)
	{
		List<Category> category = boardMapper.boardCategoryByBoardId(boardId);
		return category;
	}
	
	public List<Category> boardCategory(int meetingId)
	{
		List<Category> category = boardMapper.boardCategory(meetingId);
		return category;
	}
	
	public int addInMeeting(Meeting meeting)
	{
		Board board = new Board();
		board.setMeetingId(meeting.getId());
		board.setName(meeting.getName());
		boardMapper.insert(board); //
		
		//test
		System.out.println("board id : "+board.getId());
		System.out.println("board meetingId : "+board.getMeetingId());
		System.out.println("board name : "+board.getName());
		
		return board.getId();
	}
	
	public void defaultCategory(int boardId)
	{
		boardMapper.defaultCategory("공지", boardId);
		boardMapper.defaultCategory("잡담", boardId);
	}
}
