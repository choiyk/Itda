package com.kyung.dto;

import java.util.Date;

public class File {
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
	public Date getFileTime() 
	{
		return fileTime;
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
