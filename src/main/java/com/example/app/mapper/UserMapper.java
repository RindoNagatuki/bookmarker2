package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserMapper {

	//ユーザー一覧の取得
	List<User> selectAll();
	
	//登録
	void add(User user);
	
	// ユーザー1件分の情報を取ってくる→ SNSのリストも含まれている
	User selectById(int id);
	
	//削除
	void delete(int id);

	
    
}
