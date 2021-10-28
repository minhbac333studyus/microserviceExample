package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateUserRequestModel {
	String firstName;
	String lastName;
	@NotNull
	@Size(min = 6, max = 20, message = "Password must contain 6 to 20 characters")
	String password;
	@NotNull(message = "Email cannot be null")
	@Email(message = "Email must be write in email format ex: abc@gmail.com")
	String email;
}
