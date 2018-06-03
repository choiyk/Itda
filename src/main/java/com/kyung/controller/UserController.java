package com.kyung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.dto.User;
import com.kyung.dto.Department;
import com.kyung.mapper.UserMapper;
import com.kyung.service.UserService;
import com.kyung.service.DepartmentService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired DepartmentService departmentService;
/*	
	@RequestMapping("user/main")
	public String main()
	{
		return "main";
	}
	
	@RequestMapping("userList")
	public String allUserList(Model model) 
	{
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		return "admin/userList";
	}
*/	
	@RequestMapping(value="create", method=RequestMethod.GET)
	public String create(Model model) 
	{
		User user = new User();
		List<Department> departments = departmentService.findAll();
		model.addAttribute("user", user);
		model.addAttribute("departments", departments);
		return "user/edit";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Model model, User user) 
	{
		userService.create(user);
		return "main";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.GET)
	public String edit(Model model, @RequestParam("id")int id) 
	{
		User user = userService.findOne(id);
		List<Department> departments = departmentService.findAll();
		model.addAttribute("user",user);
		model.addAttribute("departments",departments);
		return "user/edit";
	}
	
	@RequestMapping(value="edit", method=RequestMethod.POST)
	public String edit(Model model, User user) 
	{
		userService.update(user);
		return "main";
	}
	
	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id")int id)
	{
		userService.delete(id);
		return "main";
	}
}