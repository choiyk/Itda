package com.kyung.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.mapping.FetchType;

public class File {
	SimpleDateFormat sim = new SimpleDateFormat("yyyy.MM.dd.  a hh:mm");
	
	int id;
	int articleId; // f.k
	String fileName;
	int fileSize;
	Date fileTime;
	
	byte[] data; // file

	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getArticleId() 
	{
		return articleId;
	}
	public void setArticleId(int articleId) 
	{
		this.articleId = articleId;
	}
	public String getFileName() 
	{
		return fileName;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}
	public int getFileSize() 
	{
		return fileSize;
	}
	public void setFileSize(int fileSize) 
	{
		this.fileSize = fileSize;
	}
	public String getFileTime() 
	{
		return sim.format(fileTime);
	}
	public void setFileTime(Date fileTime) 
	{
		this.fileTime = fileTime;
	}
	public byte[] getData() 
	{
		return data;
	}
	public void setData(byte[] data) 
	{
		this.data = data;
	}
}
