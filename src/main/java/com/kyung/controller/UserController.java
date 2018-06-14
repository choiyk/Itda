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

import com.kyung.dto.Department;
import com.kyung.dto.Meeting;
import com.kyung.dto.User;
import com.kyung.dto.UserJoinedMeetings;
import com.kyung.model.UserModificationModel;
import com.kyung.model.UserPasswdModificationModel;
import com.kyung.model.UserPasswordCheckModel;
import com.kyung.model.UserRegistrationModel;
import com.kyung.service.DepartmentService;
import com.kyung.service.UserService;
import com.kyung.utils.Encryption;

@Controller
public class UserController {
	@Autowired UserService userService;
	@Autowired DepartmentService departmentService;

	@RequestMapping("main")
	public String main(Model model)
	{
		System.out.println("login success");
		User user = userService.getCurrentUser();
		List<UserJoinedMeetings> list = userService.userJoinMeetings(user.getId());
		
		if(list.size()>0) System.out.println(list.get(0));
		else System.out.println("null");
		
		model.addAttribute("meetings",list);
		model.addAttribute("type",user.getType());
		return "user/main";
	}

	@RequestMapping("mypage")
	public String mypage(Model model)
	{
		User user = userService.getCurrentUser();
		model.addAttribute("user",user);
		return "user/mypage";
	}

	@RequestMapping(value="myinfo_setting", method=RequestMethod.GET)
	public String myinfoSetting(UserModificationModel userModel, Model model)
	{
		System.out.println("info get");
		User user = userService.getCurrentUser(); 
		user = userService.findOne(user.getId());
		
		//System.out.println("userModel nickname:"+userModel.getNickname());
		userModel = userModel.inputUser(user);
		
		//System.out.println(userModel.getGender());
		model.addAttribute("userModificationModel",userModel);
		//model.addAttribute("department", user.getDepartmentId());
		model.addAttribute("departments", departmentService.findAll());
		return "user/myinfo_setting";
	}

	@RequestMapping(value="myinfo_setting", method=RequestMethod.POST)
	public String myinfoSetting(@Valid UserModificationModel userModel, BindingResult bindingResult, Model model)
	{
		System.out.println("정보 변경");
		User currentUser = userService.getCurrentUser();
		currentUser = userService.findOne(currentUser.getId());

		if(bindingResult.hasErrors())
		{
			System.out.println("정보 변경 에러");
			User user = userService.getCurrentUser();
			model.addAttribute("user", user);
			model.addAttribute("departments", departmentService.findAll());
			return "user/myinfo_setting";
		}
		System.out.println("정보변경 진행중");
		User user = userModel.toUser(currentUser); // add pw
		System.out.println("정보변경 진행중2");
		userService.edit(user);
		System.out.println("정보변경 성공");

		model.addAttribute("msg", "정보가 변경되었습니다.");
		model.addAttribute("url", "mypage");
		return "redirect";

		/*return "redirect:mypage";*/
	}


	@RequestMapping(value="mypw_auth", method=RequestMethod.GET)
	public String mypw_auth(UserPasswordCheckModel userModel, Model model)
	{
		System.out.println("mypw_auth get");
		return "user/mypw_auth";
	}

	@RequestMapping(value="mypw_auth", method=RequestMethod.POST)
	public String mypw_auth(@Valid UserPasswordCheckModel userModel, BindingResult bindingResult, Model model)
	{
		System.out.println("mypw_auth post");
		User user = userService.getCurrentUser();
		user = userService.findOne(user.getId());
		String password = userModel.getPassword();
		password = Encryption.encrypt(password, Encryption.SHA256);

		if(userService.passwordComparison(user.getPassword(), password, bindingResult)) // equal == true
		{
			System.out.println("pw 일치");
			return "redirect:mypw_setting";
		}
		else
		{
			System.out.println("pw 불일치");
			return "user/mypw_auth";
		}
	}

	@RequestMapping(value="mypw_setting", method=RequestMethod.GET)
	public String mypwSetting(UserPasswdModificationModel userModel, Model model)
	//public String mypwSetting()
	{
		System.out.println("pw setting get");
		return "user/mypw_setting";
	}

	@RequestMapping(value="mypw_setting", method=RequestMethod.POST)
	public String mypwSetting(@Valid UserPasswdModificationModel userModel, BindingResult bindingResult, Model model)
	{
		System.out.println("pw setting post");
		if(bindingResult.hasErrors())
		{
			System.out.println("pw1,2 형식 에러");
			return "user/mypw_setting";
		}
		if(userService.passwordComparisonEdit(userModel.getPassword1(), userModel.getPassword2(), bindingResult))
		{
			System.out.println("pw1,2 같음");
			User user = userService.getCurrentUser();
			System.out.println(userModel.getPassword1());
			userService.pwUpdate(user, userModel.getPassword1());
			return "redirect:mypage";
		}
		return "user/mypw_setting";
	}

	@RequestMapping("my_meeting")
	public String myMeeting()
	{
		return "user/my_meeting";
	}

	@RequestMapping("my_article")
	public String myArtilce()
	{
		return "user/my_article";
	}

	@RequestMapping("my_comment")
	public String myComment()
	{
		return "user/my_comment";
	}

/*
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
	public String delete()
	{
		User user = userService.getCurrentUser();
		userService.delete(user.getId());
		return "redirect:/";
	}
}