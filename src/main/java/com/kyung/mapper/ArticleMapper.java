package com.kyung.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.dto.Article;

@Mapper
public interface ArticleMapper {
	void insert(@Param("boardId") int boardId, @Param("userId") int userId,
			@Param("title") String title, @Param("contents") String contents, @Param("category")int category);
	Article findOne(@Param("boardId") int boardId, @Param("articleId") int articleId);
	void update(@Param("articleId") int articleId, @Param("title") String title, @Param("contents") String contents, @Param("category")int category);
	void delete(@Param("articleId") int articleId);
}
