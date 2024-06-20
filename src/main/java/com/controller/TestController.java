package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//http://localhost:8081/display
	@RequestMapping("display")
	public String display() {
		return "welcome niku to spring boot";
	}
	
	@RequestMapping("show/{}username")
	public String show(@PathVariable String username) {
		return "welcome  to spring boot "+username;
	}
}

