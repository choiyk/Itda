package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.Comment;
import com.kyung.mapper.CommentMapper;

@Service
public class CommentService 
{
	@Autowired CommentMapper commentMapper;
	
	public void delete(int commentId)
	{
		commentMapper.delete(commentId);
	}
	
	public List<Comment> findAllByArticle(int articleId)
	{
		System.out.println("comment service : findcomments");
		List<Comment> comments = commentMapper.findAllByArticle(articleId);
		return comments;
	}
	
	public void create(int writer, int article, String content)
	{
		System.out.println("comment service : create"); 
		commentMapper.insert(writer,article,content);
	}
}
