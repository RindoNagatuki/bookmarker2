package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserMapper mapper;

	//リスト表示
	@GetMapping("/user")
	public String userListPage(Model model) {
		// マッパーを使い、ユーザー一覧を取得→モデルに格納
		model.addAttribute("users", mapper.selectAll());
		return "userList";
	}

	//ユーザー追加の表示
	@GetMapping("/user/add")
	public String userAddPage(Model model, User user) {
		model.addAttribute("user", new User());
		return "userAdd";
	}

	//ユーザー追加の受け取り

	@PostMapping("/user/add") //↓入力を受け取るためのもの
	public String userAddPage(@Valid @ModelAttribute User user, Errors errors) {
		System.out.println(user);
		if (errors.hasErrors()) {
			return "userAdd";
		}
		// mapperを使って、データを登録
		mapper.add(user);
		System.out.println(user);
		return "redirect:/user";
	}

	//登録内容個別表示
	//マッパーを使ってSNS情報登録内容を取得
	@GetMapping("/user/show/{id}")
	public String userShowPage(@PathVariable("id") int id, Model model) {
		System.out.println(mapper.selectById(id));
		model.addAttribute("user", mapper.selectById(id));
		return "userShow";
	}

}
