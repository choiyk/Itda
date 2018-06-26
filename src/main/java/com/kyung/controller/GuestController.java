package com.kyung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyung.dto.User;
import com.kyung.dto.UserJoinedMeetings;
import com.kyung.model.FindPwModel;
import com.kyung.model.ResultModel;
import com.kyung.model.UserPasswdModificationModel;
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
	public String login(Model model)
	{
		User user = userService.getCurrentUser();

		if(user != null) // login
		{
			List<UserJoinedMeetings> list = userService.userJoinMeetings(user.getId());
			model.addAttribute("meetings",list);
			model.addAttribute("type",user.getType());

			return "user/main";
		}
		else
		{
			return "guest/login";
		}
	}


	@RequestMapping(value="guest/join", method=RequestMethod.GET)
	public String join(UserRegistrationModel userModel, Model model)
	{
		User user = userService.getCurrentUser();

		if(user != null) // login
		{
			List<UserJoinedMeetings> list = userService.userJoinMeetings(user.getId());
			model.addAttribute("meetings",list);
			model.addAttribute("type",user.getType());

			return "redirect:main";
		}
		else
		{
			model.addAttribute("departments", departmentService.findAll());
			return "guest/join";
		}
	}

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
		return "redirect:login";
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

	@RequestMapping(value="guest/findPw", method=RequestMethod.GET)
	public String findPw(Model model, FindPwModel findPwModel){

		return "guest/findPw";

	}

	@RequestMapping(value="guest/findPw", method=RequestMethod.POST)
	public String findPw(Model model, @Valid FindPwModel findPwModel, BindingResult bindingResult){

		if(userService.hasErrors(findPwModel, bindingResult))
		{
			return "guest/findPw";
		}

		ResultModel result = userService.findPw(findPwModel);

		if(result.getResult()){
			return "redirect:/guest/settingPw?st="+result.getExplain();
		}
		else{
			model.addAttribute("msg", result.getExplain());
			model.addAttribute("url", "guest/login");
			return "redirect";
		}

	}

	@RequestMapping(value="guest/settingPw", method=RequestMethod.GET)
	public String settingPw(Model model, @RequestParam(value="st") String studentNumber, UserPasswdModificationModel userPasswdModificationModel){

		return "guest/mypw_setting";

	}

	@RequestMapping(value="guest/settingPw", method=RequestMethod.POST)
	public String settingPw(Model model, @RequestParam(value="st") String studentNumber, @Valid UserPasswdModificationModel userModel, BindingResult bindingResult){

		User user = userService.findByStudentNumber(studentNumber);

		if(bindingResult.hasErrors())
		{
			System.out.println("pw1,2 형식 에러");
			return "guest/mypw_setting";
		}
		else if(userService.passwordComparisonEdit(userModel.getPassword1(), userModel.getPassword2(), bindingResult))
		{
			System.out.println("pw1,2 같음");
			System.out.println(userModel.getPassword1());
			userService.pwUpdate(user, userModel.getPassword1());

			model.addAttribute("msg", "비밀번호가 변경되었습니다. 다시 로그인 해 주세요.");
			model.addAttribute("url", "guest/login");
			return "redirect";
		}

		return "guest/login";

	}

}
