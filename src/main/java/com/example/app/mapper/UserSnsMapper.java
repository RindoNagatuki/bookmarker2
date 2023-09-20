package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.UserSns;

@Mapper
public interface UserSnsMapper {

	//ユーザー（個人）登録内容の取得
	List<UserSns> selectAll();
	
	//登録
	void snsAdd(UserSns userSns);
}
