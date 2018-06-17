package com.kyung.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.dto.ArticlesByMeeting;
import com.kyung.dto.Board;
import com.kyung.dto.Category;
import com.kyung.dto.Meeting;
import com.kyung.dto.User;
import com.kyung.dto.UserByMeeting;
import com.kyung.dto.UserJoinedMeetings;
import com.kyung.model.MeetingRegistrationModel;
import com.kyung.service.MeetingService;
import com.kyung.service.UserService;
import com.kyung.service.BoardService;

@Controller
public class MeetingController {
	@Autowired UserService userService;
	@Autowired MeetingService meetingService;
	@Autowired BoardService boardService;
	
	@RequestMapping(value="meeting", method=RequestMethod.GET)
	public String meeting(@RequestParam(value="id") int meetingId, Model model)
	{
		System.out.println("meeting get main");
		
		String menu="";
		Meeting meeting = new Meeting();
		
		meeting = meetingService.findOne(meetingId);
		menu = meeting.getName();
		model.addAttribute("menu",menu);
		
		User user = userService.getCurrentUser();
		
		UserByMeeting result = meetingService.findUserByMeeting(meeting.getId(), user.getId());
		
		if(result.getMeetingId() == -1)
		{
			return "redirect:main";
		}
		
		/* error
		if(userByMeeting.getMeetingId() == -1)
		{
			return "redirect:main";
		}*/
		
		model.addAttribute("user",result);
		
		List<Category> category = boardService.boardCategory(meeting.getId());
		model.addAttribute("category", category);
		
		List<ArticlesByMeeting> list = boardService.boardArticles(meeting.getId());
		model.addAttribute("articles",list);
		
		Board board = meetingService.findBoardByMeeting(meeting.getId());
		model.addAttribute("board",board);
		
		/*
		if(list.get(0) == null) System.out.println("null");
		else list.get(0).toString();
		*/
		System.out.println("meeting "+menu);
		return "user/meeting";
	}
	
	@RequestMapping(value="meeting", method=RequestMethod.POST)
	public String meeting()
	{
		System.out.println("meeting post");
		return "user/meeting";
	}
	
	@RequestMapping(value="meeting_create", method=RequestMethod.GET)
	public String meeting_create(MeetingRegistrationModel meetingModel, Model model)
	{
		System.out.println("meeting_create get");
		String menu="모임 생성";
		model.addAttribute("menu", menu);
		return "user/meeting_create";
	}
	
	@RequestMapping(value="meeting_create", method=RequestMethod.POST)
	public String meeting_create(HttpServletRequest request, @Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_create post");
		String menu=request.getParameter("meetingName");
		model.addAttribute("menu",menu);
		if(bindingResult.hasErrors())
		{
			return "user/meeting_create";
		}
		
		User user=userService.getCurrentUser();
		meetingModel.setExplain(request.getParameter("explain")); // form validation 적용 후 삭제 
		System.out.println("requestparam : "+ request.getParameter("explain"));
		int id = meetingService.create(meetingModel, user);
		
		return "redirect:meeting?id="+id;
	}

	@RequestMapping(value="usersave", method=RequestMethod.GET)
	public String meeting_setting_usersave(@RequestParam(value="id") int id, MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_save");
		List<User> saveuser = new ArrayList<>();
		User user = userService.findOne(id);
		saveuser.add(user);
		System.out.println(user.getName());
		model.addAttribute("saveuser",saveuser);
		return "user/meeting_setting";
	}
	
	@RequestMapping(value="userfind", method=RequestMethod.POST)
	public String meeting_setting_userfind(HttpServletRequest request, MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_userfind");
		String studentNumber = request.getParameter("studentNumber");
		model.addAttribute("finduser", userService.findByStudentNumber(studentNumber));
		User user = userService.findByStudentNumber(studentNumber);
		System.out.println(studentNumber);
		/*if(bindingResult.hasErrors())
		{
			return "user/meeting_setting";
		}*/
		return "user/meeting_setting";
	}
	
	@RequestMapping(value="meeting_setting", method=RequestMethod.GET)
	public String meeting_setting(MeetingRegistrationModel meetingModel, Model model)
	{
		System.out.println("meeting setting_GET");
		String menu="모임 정보 수정";
		User user = null;
		model.addAttribute("user", user);
		model.addAttribute("menu", menu);
		return "user/meeting_setting";
	}
	
	@RequestMapping(value="meeting_setting", method=RequestMethod.POST)
	public String meeting_setting(@Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting setting_POST");
		String menu="모임 정보 수정";
		
		if(bindingResult.hasErrors())
		{
			return "user/meeting_setting";
		}
		
		model.addAttribute("menu", menu);
		return "user/meeting";
	}
	
	
}
