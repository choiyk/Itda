package com.kyung.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kyung.dto.File;

@Mapper
public interface FileMapper 
{
	void delete(int id);
	void insert(File file);
	List<File> findAll();
	File findOne(int id);
}
