package com.example.spring1.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestTestController {
	
	@RequestMapping("/rest")
	public String ssasdas() {
		return "/rest/rest";
	}
}
