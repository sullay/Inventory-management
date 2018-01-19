package com.sullay.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("/")
	public String index() {
		return "/hello.html";
	}
	@RequestMapping("/login_page")
	public String loginPage() {
		return "/login.html";
	}
}
