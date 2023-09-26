package com.example.app.domain;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

	private Integer id;
	@NotBlank
	private String name;
	
	private List<UserSns> snsList;
}
