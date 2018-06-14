package com.kyung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kyung.dto.User;
import com.kyung.dto.UserJoinedMeetings;
import com.kyung.service.UserService;

@Controller
public class AdminController {
	
	@Autowired UserService userService;

	@RequestMapping("admin_user")
	public String admin_user(Model model)
	{
		User user = userService.getCurrentUser();
		
		if(user.getType() != 1)
		{
			List<UserJoinedMeetings> list = userService.userJoinMeetings(user.getId());
			model.addAttribute("meetings",list);
			model.addAttribute("type",user.getType());
			
			return "user/main";
		}
		else
		{
			return "admin/admin_user";
		}
	}
}
