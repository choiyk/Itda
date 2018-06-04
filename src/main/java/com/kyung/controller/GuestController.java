package com.kyung.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kyung.dto.User;
import com.kyung.model.UserRegistrationModel;
import com.kyung.mapper.DepartmentMapper;
import com.kyung.mapper.UserMapper;

@Controller
public class GuestController 
{
	@Autowired DepartmentMapper departmentMapper;
	@Autowired UserMapper userMapper;
	
	/*
	@RequestMapping({"/","guest/index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("guest/login")
	public String login() {
		return "guest/login";
	}
	*/
	
	@RequestMapping(value="guest/join", method=RequestMethod.GET)
	public String join(UserRegistrationModel user, Model model) {
		model.addAttribute("departments", departmentMapper.findAll());
		return "guest/join";
	}
	
	@RequestMapping(value="guest/join", method=RequestMethod.POST)
	public String join(@Valid UserRegistrationModel userModel, Model model, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			model.addAttribute("departments", departmentMapper.findAll());
			return "guest/join";
		}
		User user = userModel.toUser();
		user.setType(2); // 2: user
		userMapper.insert(user);
		return "redirect:success";
	}
	
	@RequestMapping("success")
	public String success()
	{
		System.out.println("success");
		return "guest/login";
	}
	
}
