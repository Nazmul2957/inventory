package com.example.inventory3.inventory3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
public String index() {
	return "AircraftAdmin-Free/index";
}
	
		@RequestMapping("/test")
	public String index2() {
		return "add";
	}
}

