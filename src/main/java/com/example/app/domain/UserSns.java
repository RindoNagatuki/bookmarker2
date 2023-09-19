package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserSns {

	private Integer id;
	@NotBlank
	private String snsName;
	
	private String url;
	private String AccountName;
	@NotBlank(message = "整数で入力してください")
	private Integer userId;
}
