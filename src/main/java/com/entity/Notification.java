package com.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String text;

//	@Enumerated(EnumType.STRING)
	private String status;

	private Integer mittente;

	private Integer destinatario;

	@UpdateTimestamp
	@Column(name = "created_date")
	private Timestamp createdDate;

	public Notification(String text, String status, Integer mittente, Integer destinatario) {
		this.text = text;
		this.status = status;
		this.mittente = mittente;
		this.destinatario = destinatario;
	}

	/*
	public Notification(Integer id, String status) {
		this.id = id;
		this.status = status;
	}*/

}
