package com.project.questapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {

	@Id
	private Long id;
	private Long userId;
	private String title;
	
	@Lob
	@Column(columnDefinition = "text")
	private String text;
	
}
