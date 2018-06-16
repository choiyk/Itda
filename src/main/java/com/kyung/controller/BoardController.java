package com.kyung.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.dto.Category;
import com.kyung.dto.User;
import com.kyung.model.ArticleRegistrationModel;
import com.kyung.service.BoardService;
import com.kyung.service.UserService;
import com.kyung.service.ArticleService;

@Controller
public class BoardController 
{
	@Autowired BoardService boardService;
	@Autowired UserService userService;
	@Autowired ArticleService articleService;
	
	@RequestMapping(value="article", method=RequestMethod.GET)
	public String article(Model model)
	{
		System.out.println("article get");
		return "user/article";
	}
	/*
	@RequestMapping(value="article", method=RequestMethod.POST)
	public String article(Model model)
	{
		System.out.println("article post");
	}
*/
	
	@RequestMapping(value="article_write", method=RequestMethod.GET)
	public String articleWrite(@RequestParam(value="bd") int boardId, ArticleRegistrationModel articleModel, Model model)
	{
		System.out.println("board get article write : "+boardId);
		
		String menu="게시글 작성";
		model.addAttribute("menu", menu);
		
		List<Category> category = boardService.boardCategoryByBoardId(boardId);
		model.addAttribute("category", category);
		
		return "user/article_write";
	}
	
	@RequestMapping(value="article_write", method=RequestMethod.POST)
	public String articleWrite(@RequestParam(value="bd") int boardId, HttpServletRequest request, 
				@Valid ArticleRegistrationModel articleModel, BindingResult bindingResult, Model model)
	{
		System.out.println("board post article write");
		
		String menu="게시글 작성";
		model.addAttribute("menu", menu);
		
		if(bindingResult.hasErrors())
		{
			List<Category> category = boardService.boardCategoryByBoardId(boardId);
			model.addAttribute("category", category);
			return "user/article_write";
		}
		 
		User user = userService.getCurrentUser();
		articleModel.setContents(request.getParameter("contents")); // form validation 적용 후 삭제
		
		articleService.create(boardId, user.getId(), articleModel);
		
		System.out.println("boardId "+boardId); //
		int meetingId = boardService.findMeetingByBoard(boardId);
		
		return "redirect:meeting?id="+meetingId;
	}
}
