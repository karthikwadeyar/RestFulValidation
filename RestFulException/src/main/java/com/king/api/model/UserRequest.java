package com.king.api.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequest {

	@NotNull(message = "username shouldn't null")
	private String name;
	@Email(message = "Invalid Email Address")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	private String mobile;
	
	private String gender;
	@Min(value = 18)
	@Max(value = 60)
	private int age;
	@NotBlank
	private String natonality;
}
