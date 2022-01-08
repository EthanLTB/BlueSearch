package com.wadocoder.BlueSearch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

	@GetMapping("/dashboard")
	public String getDashboard() {
		
		return "dashboard";
	}
}
