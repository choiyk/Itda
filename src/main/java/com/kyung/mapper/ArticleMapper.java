package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kyung.dto.Article;

@Mapper
public interface ArticleMapper {
	void insert(@Param("boardId") int boardId, @Param("userId") int userId,
			@Param("title") String title, @Param("contents") String contents, @Param("category")int category);
	Article findOne(@Param("boardId") int boardId, @Param("articleId") int articleId);
	List<Article> findNotice();
	void update(@Param("articleId") int articleId, @Param("title") String title, @Param("contents") String contents, @Param("category")int category);
	void delete(@Param("articleId") int articleId);
}
