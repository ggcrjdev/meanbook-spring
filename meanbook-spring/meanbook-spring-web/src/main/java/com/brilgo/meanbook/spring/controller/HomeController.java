package com.brilgo.meanbook.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String viewRoot() {
		return "index";
	}
	
	@RequestMapping("/index.html")
	public String viewIndex() {
		return "index";
	}
	
	@RequestMapping("/home")
	public String viewHome() {
		return "home";
	}
}
