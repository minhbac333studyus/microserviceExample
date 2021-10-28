package com.example.demo.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 4859352825269969317L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String userId;
	@Column(nullable = false)
	private String encryptedPassword;
}
