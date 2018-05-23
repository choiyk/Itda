package com.kyung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("guest/join")
	public String join(){
		return "guest/join";
	}

	@RequestMapping("guest/login")
	public String login(){
		return "guest/login";
	}

	@RequestMapping("main")
	public String main(){
		return "main";
	}

	@RequestMapping("meeting")
	public String meeting(){
		return "meeting";
	}

	@RequestMapping("article")
	public String article(){
		return "article";
	}

}
