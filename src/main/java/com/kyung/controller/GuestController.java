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
import com.kyung.service.DepartmentService;
import com.kyung.service.UserService;

@Controller
public class GuestController 
{
	@Autowired DepartmentService departmentService;
	@Autowired UserService userService;
	
	@RequestMapping({"/","/index"})
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("guest/login")
	public String login() {
		return "guest/login";
	}
	
	
	@RequestMapping(value="guest/join", method=RequestMethod.GET)
	public String join(UserRegistrationModel userModel, Model model) 
	{
		model.addAttribute("departments", departmentService.findAll());
		return "guest/join";
	}
	
	/*
	private boolean isValid(UserRegistrationModel userModel, BindingResult bindingResult) 
	{
		if(userModel.getPassword1().equals(userModel.getPassword2())==false)
		{
			bindingResult.rejectValue("password2", null, "비밀번호가 일치하지 않습니다.");
			return false;
		}
		User user = userService.findByStudentNumber(userModel.getStudentNumber());
		if(user != null)
		{
			bindingResult.rejectValue("studentNumber", null, "학번이 중복됩니다.");
			return false;
		}
		return true;
	}
	
	@RequestMapping(value="guest/join", method=RequestMethod.POST)
	public String join(@Valid UserRegistrationModel userModel, BindingResult bindingResult, Model model) 
	{
		if(bindingResult.hasErrors() || isValid(userModel, bindingResult)==false)
		{
			model.addAttribute("departments", departmentService.findAll());
			return "guest/join";
		}
		User user = userModel.toUser();
		user.setType(2); // 2: user
		if(user.getNickname() == "")
			user.setNickname(user.getName());
		userService.join(user);
		//return "redirect:success";
		return "guest/login";
	}*/
	
	@RequestMapping(value="guest/join", method=RequestMethod.POST)
	public String join(@Valid UserRegistrationModel userModel, BindingResult bindingResult, Model model) 
	{
		if(userService.hasErrors(userModel, bindingResult))
		{
			model.addAttribute("departments", departmentService.findAll());
			return "guest/join";
		}
		
		userService.join(userModel);
		
		//return "redirect:success";
		return "guest/login";
	}
	
	//로그인 성공 시 alert창 추가 예정 
	/*
	@RequestMapping("success")
	public String success()
	{
		System.out.println("success");
		return "guest/login";
	}
	*/
	
}
