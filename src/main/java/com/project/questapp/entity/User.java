package com.project.questapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
}
