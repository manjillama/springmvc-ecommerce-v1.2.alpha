package com.manjiltamang.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccessDenied {
	@RequestMapping("/403")
	@ResponseBody
	public String message(){
		return "Oops! You're not allowed to access this page!";
	}
}
