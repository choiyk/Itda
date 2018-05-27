package com.kyung.mapper;

import java.util.List;

import com.kyung.dto.Board;

public interface BoardMapper {
	Board findOne(int id);
	List<Board> findAll();
	void insert(Board board);
	void delete(int id);
}
