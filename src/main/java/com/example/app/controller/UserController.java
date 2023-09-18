package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UserController {

	
	
	@GetMapping("/users")
	public String userListPage(Model model)throws Exception{
		return "userList";
	}
	@PostMapping("/users/add ")
	public String userAddPage(Model model)throws Exception{
		
		
		return "redirect:/userList";
	}
	
	@GetMapping("/userShow")
	public String userShowPage() {
		return "/userShow";
	}
	
	
	
	
	
}
