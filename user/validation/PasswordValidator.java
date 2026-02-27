package com.seveneleven.mycontactsapp.user.validation;


import java.util.regex.Pattern;

public class PasswordValidator {
	private String pattern= "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])$";
	String password;
	
	public PasswordValidator(String password) {
		this.password=password;
	
	if (Pattern.matches(pattern, password)) { 
		System.out.println("Password is strong.");
	} 
	else { 
		System.out.println("Password does not meet integrity requirements."); 
	}
  }
}

