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

import com.kyung.dto.Article;
import com.kyung.dto.Category;
import com.kyung.dto.Comment;
import com.kyung.dto.User;
import com.kyung.model.ArticleRegistrationModel;
import com.kyung.model.CommentRegistrationModel;
import com.kyung.service.ArticleService;
import com.kyung.service.BoardService;
import com.kyung.service.CommentService;
import com.kyung.service.UserService;

@Controller
public class BoardController
{
	@Autowired BoardService boardService;
	@Autowired UserService userService;
	@Autowired ArticleService articleService;
	@Autowired CommentService commentService;

	@RequestMapping(value="comment_delete")
	public String commentDelete(Model model, @RequestParam(value="bd") int boardId, @RequestParam(value="at") int articleId,
			@RequestParam(value="ct")int commentId)
	{
		
		commentService.delete(commentId);
		
		model.addAttribute("msg", "삭제되었습니다.");
		model.addAttribute("url", "article?bd="+boardId+"&at="+articleId);
		
		return "redirect";
	}
	
	@RequestMapping(value="article", method=RequestMethod.GET)
	public String article(@RequestParam(value="bd")int boardId, @RequestParam(value="at") int articleId, 
			CommentRegistrationModel commentModel, Model model)
	{
		System.out.println("* article get bd:"+boardId+" at:"+articleId);
		
		Article article = new Article();
		article = articleService.findOne(boardId, articleId);
		model.addAttribute("article",article);

		int meetingId = boardService.findMeetingByBoard(boardId);
		model.addAttribute("id", meetingId);
		
		List<Comment> comments = commentService.findAllByArticle(articleId);
		
		model.addAttribute("comments",comments);
		
		User user = userService.getCurrentUser();
		model.addAttribute("user",user);
		
		System.out.println("view return");
		return "user/article";
	}

	@RequestMapping(value="article", method=RequestMethod.POST)
	public String comment_write(@RequestParam(value="bd") int boardId, @RequestParam(value="at") int articleId, 
			@Valid CommentRegistrationModel commentModel, BindingResult bindingResult, Model model)
	{
		System.out.println("* comment_write");
		
		Article article = new Article();
		article = articleService.findOne(boardId, articleId);
		model.addAttribute("article",article);
		
		int meetingId = boardService.findMeetingByBoard(boardId);
		model.addAttribute("id", meetingId);
		
		if(bindingResult.hasErrors())
		{
			System.out.println("binding result");
			
			List<Comment> comments = commentService.findAllByArticle(articleId);
			model.addAttribute("comments",comments);
			
			return "user/article";
		}
		
		System.out.println("register ing...");

		User user = userService.getCurrentUser();
		commentService.create(user.getId(),articleId,commentModel.getContent());
		System.out.println("comment create");
		
		model.addAttribute("user",user);
		
		List<Comment> comments = commentService.findAllByArticle(articleId); 
		model.addAttribute("comments",comments);
		System.out.println("comment list");
		
		return "redirect:article?bd="+boardId+"&at="+articleId;
	}


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

	@RequestMapping(value="article_edit", method=RequestMethod.GET)
	public String articleEdit(Model model, ArticleRegistrationModel articleModel, @RequestParam(value="bd") int boardId, @RequestParam(value="at") int articleId, HttpServletRequest request){

		String menu="게시글 수정";
		model.addAttribute("menu", menu);

		List<Category> category = boardService.boardCategoryByBoardId(boardId);
		model.addAttribute("category", category);

		Article article = articleService.findOne(boardId, articleId);
		articleModel.setTitle(article.getTitle());
		articleModel.setContents(article.getContent());
		articleModel.setCategory(article.getCategory());

		return "user/article_write";
	}

	@RequestMapping(value="article_edit", method=RequestMethod.POST)
	public String articleEdit(Model model, @Valid ArticleRegistrationModel articleModel, BindingResult bindingResult, @RequestParam(value="bd") int boardId, @RequestParam(value="at") int articleId, HttpServletRequest request){

		String menu="게시글 수정";
		model.addAttribute("menu", menu);

		if(bindingResult.hasErrors())
		{
			List<Category> category = boardService.boardCategoryByBoardId(boardId);
			model.addAttribute("category", category);

			Article article = articleService.findOne(boardId, articleId);
			articleModel.setTitle(article.getTitle());
			articleModel.setContents(article.getContent());
			articleModel.setCategory(article.getCategory());

			return "user/article_write";
		}

		articleModel.setContents(request.getParameter("contents")); // form validation 적용 후 삭제

		articleService.edit(articleId, articleModel);

		return "redirect:article?bd="+boardId+"&at="+articleId;

	}

	@RequestMapping(value="article_delete")
	public String articleDelete(Model model, @RequestParam(value="bd") int boardId, @RequestParam(value="at") int articleId){

		articleService.delete(articleId);

		int meetingId = boardService.findMeetingByBoard(boardId);

		model.addAttribute("msg", "삭제되었습니다.");
		model.addAttribute("url", "meeting?id="+meetingId);
		return "redirect";
	}
}
