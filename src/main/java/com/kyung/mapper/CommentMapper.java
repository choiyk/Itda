package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.dto.Comment;

@Mapper
public interface CommentMapper 
{
	void update(@Param(value="writer")int writer, @Param(value="cmtId")int cmtId, @Param(value="content")String content);
	void delete(int commentId);
	List<Comment> findAllByArticle(int articleId);
	void insert(@Param(value="writer")int writer, @Param(value="article")int article, @Param(value="content")String content);
}
