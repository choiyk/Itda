package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.Board;

@Mapper
public interface BoardMapper {
	Board findOne(int id);
	List<Board> findAll();
	void insert(Board board);
	void delete(int id);
}
