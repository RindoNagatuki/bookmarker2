package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.UserSns;

import jakarta.validation.Valid;

@Controller

public class SnsController {

	
	
	
	@GetMapping("/sns")
	public String snsAddPage(Model model)throws Exception {
		model.addAttribute("userSns", new UserSns());
		return "redirect:/user";

	}

	@PostMapping("/sns")
	public String snsAddPage(@Valid @ModelAttribute UserSns userSns, Errors errors) throws Exception {
		if (errors.hasErrors()) {
			return "snsAdd";
		}
		//mapperの追加をする
		return "redirect:/user";

	}
}
// /snsを単体で表示させる