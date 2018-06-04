package com.kyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/*
	@RequestMapping("guest/join")
	public String join(){
		return "guest/join";
	}
	*/

	@RequestMapping("guest/login")
	public String login(){
		return "guest/login";
	}

	@RequestMapping("main")
	public String main(){
		return "user/main";
	}

	@RequestMapping("meeting")
	public String meeting(){
		return "user/meeting";
	}

	@RequestMapping("article")
	public String article(){
		return "user/article";
	}

	@RequestMapping("article_write")
	public String articleWrite(){
		return "user/article_write";
	}

	@RequestMapping("meeting_setting")
	public String meetingSetting(){
		return "user/meeting_setting";
	}

	@RequestMapping("mypage")
	public String mypage(){
		return "user/mypage";
	}

	@RequestMapping("myinfo_setting")
	public String myinfoSetting(){
		return "user/myinfo_setting";
	}

	@RequestMapping("mypw_auth")
	public String mypw_auth(){
		return "user/mypw_auth";
	}

	@RequestMapping("mypw_setting")
	public String mypwSetting(){
		return "user/mypw_setting";
	}

	@RequestMapping("my_meeting")
	public String myMeeting(){
		return "user/my_meeting";
	}

	@RequestMapping("my_article")
	public String myArtilce(){
		return "user/my_article";
	}

	@RequestMapping("my_comment")
	public String myComment(){
		return "user/my_comment";
	}

}

