package com.kyung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyung.dto.File;
import com.kyung.mapper.FileMapper;

@Service
public class FileService 
{
	@Autowired FileMapper fileMapper;
	
	public File findOne(int id)
	{
		File file = new File();
		file = fileMapper.findOne(id);
		return file;
	}
	
	public void delete(int fileId)
	{
		fileMapper.delete(fileId);
	}
	
	public void save(File uploadedFile)
	{
		fileMapper.insert(uploadedFile);
	}
	
	public List<File> findAll()
	{
		List<File> files = fileMapper.findAll();
		return files;
	}
}
