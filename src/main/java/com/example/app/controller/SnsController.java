package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.UserSns;
import com.example.app.mapper.UserSnsMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class SnsController {
//SNS情報の追加
	
	private final UserSnsMapper mapper;
	
	@GetMapping("/snsAdd")
	public String snsAddPage(Model model, UserSns userSns) {
		model.addAttribute("userSns" , new UserSns());
		return "snsAdd";
	}
	
	@PostMapping("/snsAdd")
	public String snsAddPage (@Valid @ModelAttribute UserSns userSns, Errors errors) {
		if(errors.hasErrors()) {
			return "snsAdd";
		}
		mapper.snsAdd(userSns);
		return "redirect:/user";
		
	}
	
}
