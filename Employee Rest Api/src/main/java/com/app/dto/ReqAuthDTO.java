package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter   //deserialization
@Getter   //getting email and password
@ToString  //only for debugging
//presentation logic validations
public class ReqAuthDTO {
	@NotBlank(message="Email can't be blank")
	@Email(message="invalid email format!!")
	private String email;
	//@NotBlank(message="Password is required")
	private String password;
}
