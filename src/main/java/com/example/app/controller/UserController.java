package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.User;

import jakarta.validation.Valid;

@Controller

public class UserController {

	//リスト表示
	@GetMapping("/user")
	public String userListPage(Model model) throws Exception {
		User user = new User();
		model.addAttribute("user", user);
		return "userList";
	}

	//ユーザー追加の表示
	@GetMapping("/user/add")
	public String userAddPage(Model model) throws Exception {
		model.addAttribute("user", new User());
		return "userAdd";
	}

	//ユーザー追加の受け取り
	
	//mapperを作らないと次にいけない？
	@PostMapping("/user/add")
	public String userAddPage(@Valid User user, Errors errors) throws Exception {
		if (errors.hasErrors()) {
			return "userAdd";
		}
		
		// mapperを使って、データを登録
		
		return "redirect:/snsAdd";
	}

	//登録内容個別表示
	@GetMapping("/user/show?id=?")
	public String userShowPage() {

		return "userShow";
	}

}
