package com.kyung.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kyung.dto.File;
import com.kyung.service.FileService;

@Controller
public class FileController 
{
	@Autowired FileService fileService;
	
	@RequestMapping("file/list")
	public String list(Model model)
	{
		model.addAttribute("files", fileService.findAll());
		return "file/list";
	}
	
	@Transactional
	@RequestMapping(value="file/upload", method=RequestMethod.POST)
	public String upload(@RequestParam("fileUpload") MultipartFile[] uploadFiles) throws IOException
	{
		for(MultipartFile uploadFile : uploadFiles)
		{
			if(uploadFile.getSize() <= 0)
			{
				continue;
			}
			String fileName = Paths.get(uploadFile.getOriginalFilename()).getFileName().toString();
			File uploadedFile = new File();
			// articleId
			uploadedFile.setFileName(fileName);
			uploadedFile.setFileSize((int)uploadFile.getSize());
			uploadedFile.setFileTime(new Date());
			uploadedFile.setData(uploadFile.getBytes());
			fileService.save(uploadedFile);
		}
		return "redirect:list";
	}
	
	@RequestMapping("file/delete")
	public String delete(@RequestParam("id")int id) throws Exception
	{
		fileService.delete(id);
		return "redirect:list";
	}
	
	@RequestMapping("file/download")
	public void download(@RequestParam("id")int id, HttpServletResponse response) throws Exception
	{
		File uploadedFile = fileService.findOne(id);
		if(uploadedFile == null)
		{
			return;
		}
		String fileName = URLEncoder.encode(uploadedFile.getFileName(), "UTF-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName+";");
		
		try(BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream()))
		{
			output.write(uploadedFile.getData());
		}
	}
}
