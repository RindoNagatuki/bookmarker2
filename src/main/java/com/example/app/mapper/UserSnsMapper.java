package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.UserSns;

@Mapper
public interface UserSnsMapper {

	//登録
	void snsAdd(UserSns userSns);
}
