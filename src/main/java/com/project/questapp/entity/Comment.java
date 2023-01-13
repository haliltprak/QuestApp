package com.project.questapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {

	@Id
	private Long id;
	private Long postId;
	private Long userId;
	
	@Lob
	@Column(columnDefinition="text")
	private String text;
}
