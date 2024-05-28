package com.example.swaggersemniar.auth.entity;

import com.example.swaggersemniar.auth.dto.UserUpdateDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column
	private String phone;

	@Builder
	public User(String username, String name, String password, String phone) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	public void update(UserUpdateDto.Request dto) {
		this.username = dto.getUsername();
		this.password = dto.getPassword();
		this.name = dto.getName();
		this.phone = dto.getPhone();
	}
}
