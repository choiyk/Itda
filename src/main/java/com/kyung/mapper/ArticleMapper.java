package com.kyung.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {
	void insert(@Param("boardId") int boardId, @Param("userId") int userId, 
			@Param("title") String title, @Param("contents") String contents, @Param("category")int category);
}
