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

import com.kyung.dto.ArticlesByMeeting;
import com.kyung.dto.Board;
import com.kyung.dto.Category;
import com.kyung.dto.Meeting;
import com.kyung.dto.MeetingMember2;
import com.kyung.dto.User;
import com.kyung.dto.UserByMeeting;
import com.kyung.model.MeetingRegistrationModel;
import com.kyung.service.BoardService;
import com.kyung.service.DepartmentService;
import com.kyung.service.MeetingMemberService;
import com.kyung.service.MeetingService;
import com.kyung.service.UserService;

@Controller
public class MeetingController {
	@Autowired UserService userService;
	@Autowired MeetingService meetingService;
	@Autowired MeetingMemberService meetingMemberService;
	@Autowired BoardService boardService;
	@Autowired DepartmentService departmentService;

	@RequestMapping(value="meeting", method=RequestMethod.GET)
	public String meeting(@RequestParam(value="id") int meetingId, Model model)
	{
		System.out.println("meeting get main");

		String menu="";
		Meeting meeting = new Meeting();

		meeting = meetingService.findOne(meetingId);
		menu = meeting.getName();
		model.addAttribute("menu",menu);
		model.addAttribute("meeting",meeting);

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
		meetingModel.setMexplain(request.getParameter("mexplain")); // form validation 적용 후 삭제
		System.out.println("requestparam : "+ request.getParameter("mexplain"));
		int id = meetingService.create(meetingModel, user);

		return "redirect:meeting?id="+id;
	}

	@RequestMapping(value="meeting_setting", method=RequestMethod.GET)
	public String meetingSetting(Model model, @RequestParam(value="id") int id, MeetingRegistrationModel meetingModel){

		String menu = "모임 정보 수정";
		model.addAttribute("menu", menu);

		Meeting meeting  = meetingService.findOne(id);
		meetingModel.setMeetingName(meeting.getName());
		meetingModel.setMexplain(meeting.getMexplain());

		List<MeetingMember2> saveusers = meetingMemberService.findMeetingMember(id);
		model.addAttribute("saveusers", saveusers);

		model.addAttribute("id", id);

		return "user/meeting_setting";
	}

	@RequestMapping(value="meeting_setting", method=RequestMethod.POST)
	public String meetingSetting(Model model, HttpServletRequest request, @RequestParam(value="id") int id, @Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult){

		if(bindingResult.hasErrors())
		{
			String menu = "모임 정보 수정";
			model.addAttribute("menu", menu);

			Meeting meeting  = meetingService.findOne(id);
			meetingModel.setMeetingName(meeting.getName());
			meetingModel.setMexplain(meeting.getMexplain());

			return "user/meeting_setting";
		}

		meetingModel.setMexplain(request.getParameter("mexplain")); // form validation 적용 후 삭제

		meetingService.update(meetingModel, id);

		return "redirect:meeting_setting?id="+id;

	}

	@RequestMapping(value="userfind", method=RequestMethod.POST)
	public String meetingUserFind(Model model, HttpServletRequest request, @RequestParam(value="id") int id, MeetingRegistrationModel meetingModel){

		String menu = "모임 정보 수정";
		model.addAttribute("menu", menu);

		Meeting meeting  = meetingService.findOne(id);
		meetingModel.setMeetingName(meeting.getName());
		meetingModel.setMexplain(meeting.getMexplain());

		List<MeetingMember2> saveusers = meetingMemberService.findMeetingMember(id);
		model.addAttribute("saveusers", saveusers);

		String studentNumber = request.getParameter("studentNumber");
		User find = userService.findByStudentNumber(studentNumber);
		model.addAttribute("finduser", find);

		String department = departmentService.findOneByUser(find.getId());
		model.addAttribute("department",department);

		model.addAttribute("id", id);

		return "user/meeting_setting";

	}

	@RequestMapping(value="meeting_adduser", method=RequestMethod.GET)
	public String meetingAddUser(Model model, @RequestParam(value="id") int id, @RequestParam(value="uid") int userId){

		meetingMemberService.addInMeeting(id, userId, 2);

		return "redirect:meeting_setting?id="+id;

	}

	@RequestMapping(value="meeting_user_delete", method=RequestMethod.GET)
	public String meetingUserDelete(Model model, @RequestParam(value="id") int id, @RequestParam(value="mid") int meetingMemberId){

		meetingMemberService.delete(meetingMemberId);

		return "redirect:meeting_setting?id="+id;

	}



/*
	@RequestMapping(value="usersave", method=RequestMethod.GET)
	public String meeting_setting_usersave(@RequestParam(value="id") int id, @RequestParam(value="ui") int ui, MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_save");

		Meeting meeting = meetingService.findOne(id);
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);

		List<User> saveuser = new ArrayList<>();
		User user = userService.findOne(ui);
		saveuser.add(user);

		String department = departmentService.findOneByUser(user.getId());
		System.out.println("학과 출력 : "+department);
		model.addAttribute("department",department);

		System.out.println(user.getName());
		model.addAttribute("saveuser",saveuser);

		return "redirect:meeting_setting?id="+id+"&st=0";
		//return "redirect:usersave?id="+id+"&st=0";
	}*/
	/*
	@RequestMapping(value="usersave", method=RequestMethod.GET)
	public String meeting_setting_usersave(@RequestParam(value="id") int id, @RequestParam(value="st") String st,
			MeetingRegistrationModel meetingModel, Model model)
	{
		System.out.println("meeting_setting_save [get]");

		Meeting meeting = meetingService.findOne(id);
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);
		System.out.println("meeting form 내용");

		List<User> saveusers = new ArrayList<>();
		User user = userService.findByStudentNumber(st);
		saveusers.add(user);
		System.out.println("save user");

		String department = "sw";
		model.addAttribute("department",department);
		System.out.println("save departments");

		model.addAttribute("saveusers",saveusers);

		System.out.println("view return id="+id+" st="+st);
		//return "user/usersave?id="+id+"&st="+st;
		//return "redirect:usersave?id="+id+"&st="+st;
		return "user/meeting_setting";
		//return "forward:usersave?id="+id+"&st="+st;
	}

	@RequestMapping(value="usersave", method=RequestMethod.POST)
	public String meeting_setting_usersave(@RequestParam(value="id") String id, @RequestParam(value="st") String st,
			@Valid MeetingRegistrationModel meetingModel, HttpServletRequest request,BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_save [post]");

		if(id== null)
		{
			String nid = request.getParameter(id);
			String nst = request.getParameter(st);
			model.addAttribute("id",nid);
			model.addAttribute("st",nst);
		}
		else
		{
			model.addAttribute("id",id);
			model.addAttribute("st", st);
		}

		Meeting meeting = meetingService.findOne(Integer.parseInt(id));
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);

		List<User> saveusers = new ArrayList<>();
		User user = userService.findByStudentNumber(st);
		saveusers.add(user);


		String department = departmentService.findOneByUser(user.getId());
		System.out.println("학과 출력 : "+department);

		String department = "sw";
		model.addAttribute("department",department);

		//System.out.println(user.getName());
		model.addAttribute("saveusers",saveusers);

		//return "redirect:meeting_setting?id="+id+"&st=0";
		//return "redirect:usersave?id="+id+"&st=0";
		//return "user/usersave";
		return "redirect:usersave?id="+id+"&st="+st;
	}

	@RequestMapping(value="userfind", method=RequestMethod.GET)
	public String meeting_setting_userfind(@RequestParam(value="id") String id, HttpServletRequest request,
			@RequestParam(value="st") String st, MeetingRegistrationModel meetingModel, Model model)
	{
		System.out.println("meeting_setting_userfind [get]");

		model.addAttribute("id",id);

		// meeting 내용
		Meeting meeting = meetingService.findOne(Integer.parseInt(id));
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);
		// 찾은 user 내용
		User user = userService.findByStudentNumber(st);

		Optional<User> result = Optional.ofNullable(user);
		if(!result.isPresent())
		{
			System.out.println("검색 결과 없음");
			return "redirect:meeting_setting?id="+id+"&st="+st;
		}

		System.out.println("검색 결과 : "+user.getName());
		System.out.println(st);
		model.addAttribute("finduser", user);

		System.out.println("userid:"+user.getId());
		System.out.println("학과 찾기 시작");

		String department = departmentService.findOneByUser(user.getId());
		System.out.println("학과 출력 : "+department);
		model.addAttribute("department",department);

		//return "redirect:userfind?id="+id+"&st="+st;
		return "user/meeting_setting";
	}

	@RequestMapping(value="userfind", method=RequestMethod.POST)
	public String meeting_setting_userfind(@RequestParam(value="id", required=false) String id,@RequestParam(value="st", required=false) String st,HttpServletRequest request,
			@Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_userfind [post]");
		System.out.println("id:"+id);

		if(id== null)
		{
			System.out.println("첫번째");
			String nid = request.getParameter(id);
			String nst = request.getParameter(st);
			System.out.println(nid+" "+nst);
			model.addAttribute("id",nid);
			model.addAttribute("st",nst);
		}
		else
		{
			model.addAttribute("id",id);
			model.addAttribute("st", st);
		}

		//System.out.println("id : "+id);

		Meeting meeting = meetingService.findOne(id);
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);

		String studentNumber = request.getParameter("studentNumber");
		System.out.println(studentNumber);
		// error
		if(studentNumber =="")
		{
			return "redirect:meeting_setting?id="+id+"&st="+st;
		}else {
			return "redirect:userfind?id="+id+"&st="+studentNumber;
		}
		//return "user/meeting_setting?id="+id;
	}


	@RequestMapping(value="userfind", method=RequestMethod.POST)
	public String meeting_setting_userfind(@RequestParam(value="id") int id,HttpServletRequest request,
			@Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting_setting_userfind [post]");
		//System.out.println("id : "+id);

		Meeting meeting = meetingService.findOne(id);
		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);

		String studentNumber = request.getParameter("studentNumber");
		User user = userService.findByStudentNumber(studentNumber);

		Optional<User> result = Optional.ofNullable(user);
		if(!result.isPresent())
		{
			System.out.println("검색 결과 없음");
			return "redirect:meeting_setting?id="+id;
		}

		System.out.println("검색 결과 : "+user.getName());
		System.out.println(studentNumber);
		model.addAttribute("finduser", user); //

		return "redirect:userfind?id="+id;
		//return "user/meeting_setting?id="+id;
	}

	@RequestMapping(value="meeting_setting", method=RequestMethod.GET)
	public String meeting_setting(@RequestParam(value="id") int id, @RequestParam(value="st") String st,MeetingRegistrationModel meetingModel, Model model)
	{
		System.out.println("meeting setting_GET");
		String menu="모임 정보 수정";

		model.addAttribute("id",id);
		model.addAttribute("st", st);
		model.addAttribute("menu", menu);

		Meeting meeting = meetingService.findOne(id);

		User user = userService.getCurrentUser();
		UserByMeeting result = meetingService.findUserByMeeting(meeting.getId(), user.getId());
		if(result.getType() != 3)
		{
			return "redirect:main";
		}

		MeetingRegistrationModel meetingRegistrationModel = meeting.toRegistrationMeeting();
		model.addAttribute("meetingRegistrationModel", meetingRegistrationModel);


		return "user/meeting_setting";
	}

	@RequestMapping(value="meeting_setting", method=RequestMethod.POST)
	public String meeting_setting(@RequestParam(value="id") int id,HttpServletRequest request,
			@Valid MeetingRegistrationModel meetingModel, BindingResult bindingResult, Model model)
	{
		System.out.println("meeting setting_POST");

		String menu=request.getParameter("meetingName");
		model.addAttribute("menu",menu);
		if(bindingResult.hasErrors())
		{
			return "user/meeting_setting";
		}

		User user=userService.getCurrentUser();
		meetingModel.setMexplain(request.getParameter("mexplain")); // form validation 적용 후 삭제

		System.out.println("requestparam : "+ request.getParameter("mexplain"));

		model.addAttribute("user",user);
		meetingService.update(meetingModel,id);

		return "redirect:meeting?id="+id;
	}
	*/

}
