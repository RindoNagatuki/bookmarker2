package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("userSns", new UserSns());
		return "snsAdd";
	}

	@PostMapping("/snsAdd")
	public String snsAddPage(@Valid @ModelAttribute UserSns userSns, Errors errors) {
		if (errors.hasErrors()) {
			return "snsAdd";
		}
		mapper.snsAdd(userSns);
		return "redirect:/user";

	}

	@GetMapping("/sns/delete/{id}/{userId}")
	public String snsDelete(@PathVariable int id,
			@PathVariable int userId,
			RedirectAttributes rd) {
		mapper.snsDelete(id);
		rd.addFlashAttribute("statusMessage", "SNSを削除しました。");
		return "redirect:/user/show/" + userId;

	}

}
