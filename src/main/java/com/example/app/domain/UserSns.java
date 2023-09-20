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
	
	private Integer userId;
}
