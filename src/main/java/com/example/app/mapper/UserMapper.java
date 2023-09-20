package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;
import com.example.app.domain.UserSns;

@Mapper
public interface UserMapper {

	//ユーザー一覧の取得
	List<User> selectAll();
	
	//登録
	void add(User user);
	
	
	//登録内容一覧の表示
	List<UserSns> show();
}
